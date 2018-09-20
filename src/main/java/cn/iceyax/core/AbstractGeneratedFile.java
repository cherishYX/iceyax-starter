package cn.iceyax.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.iceyax.config.GeneratorParam;
import cn.iceyax.model.DataModel;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

/**
 * 根据模板生成文件
 *
 * 模板+数据=文件
 *
 * @author yanxiang
 * @date 2017/09/26
 */
public abstract class AbstractGeneratedFile {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 生成参数
     */
    protected GeneratorParam generatorParam;

    /**
     * 模板名称
     *
     * @return
     * @throws Exception
     */
    public abstract String getTemplateName();

    /**
     * 变量数据
     *
     * @return
     */
    public abstract DataModel getDataModel();

    /**
     * 文件名称
     *
     * @return
     */
    public abstract String getFileName();
    

    /**
     * 生成文件前的准备工作
     */
    public void beforeGenerateFile() {
    	
    }

    public AbstractGeneratedFile(GeneratorParam generatorParam) {
        this.generatorParam = generatorParam;
    }

    /**
     * 生成文件
     *
     * @return
     * @throws Exception
     */
    public boolean generateFile() throws Exception {
        return generateFile(true);
    }

    /**
     * 生成文件
     *
     * @param parse 是否解析
     * @return
     * @throws Exception
     */
    public boolean generateFile(boolean parse) throws Exception {

        beforeGenerateFile();
        // 设置作者 日期
        getDataModel().setAuthor(this.generatorParam.getPackageInfo().getAuthor());
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String date = dateFormat.format(now);
        getDataModel().setDate(date);
        
        // 读取模板
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_26);
        cfg.setClassForTemplateLoading(this.getClass(), "/templates/");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        Template template = cfg.getTemplate(this.getTemplateName());

        // 创建空文件
        String fileName = this.getFileName();
        int pos = fileName.lastIndexOf(File.separator);
        String fileDir = fileName.substring(0, pos + 1);

        File dir = new File(fileDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();

        // 根据模板生成文件
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
        if(parse) {
            template.process(this.getDataModel(), writer);
        } else {
            template.dump(writer);
        }
        writer.flush();
        writer.close();
        return true;
    }
}

package tools;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import test._Ibator_Run_Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GetGenerator {
    public void generator() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        // 指定配置文件
        File configFile = new File("D:\\Program Files\\IntelliJ IDEA 2019.3\\Idea-workspace\\onlymihan_scc\\src\\test\\resources\\generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
    // 执行main方法以生成代码
    public static void main(String[] args) {

        /*try {
            GetGenerator getGenerator = new GetGenerator();
            getGenerator.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        //自定义逆向工程
        _Ibator_Run_Test test = new _Ibator_Run_Test();
//         String fileName = "D:/Program Files/IntelliJ IDEA 2019.3/Idea-workspace/onlymihan_scc/src/test/resources/generatorConfig.xml";
        String fileName = "D:\\Program Files\\IntelliJ IDEA 2019.3\\Idea-workspace\\onlymihan_scc\\src\\test\\resources\\generatorConfig.xml";
        test.GeTConfiguration(fileName);
    }
}

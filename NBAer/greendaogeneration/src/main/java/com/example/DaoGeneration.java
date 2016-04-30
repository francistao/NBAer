package com.example;
import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;
public class DaoGeneration {

    public static void main(String[] args) throws Exception {
        // 正如你所见的，你创建了一个用于添加实体（Entity）的模式（Schema）对象。
        // 两个参数分别代表：数据库版本号与自动生成代码的包路径。
        Schema schema = new Schema(1, "com.geniusvjr.greendao");
        // 一旦你拥有了一个 Schema 对象后，你便可以使用它添加实体（Entities）了。
        addNews(schema);
        addStats(schema);
        // 最后我们将使用 DAOGenerator 类的 generateAll() 方法自动生成代码，此处你需要根据自己的情况更改输出目录（既之前创建的 java-gen)。
        // 其实，输出目录的路径可以在 build.gradle 中设置，有兴趣的朋友可以自行搜索，这里就不再详解。
        new DaoGenerator().generateAll(schema, "/Users/dream/Downloads/OpenSourceProjects/NBAer/app/src/main/java-gen");
    }

    public static void addNews(Schema schema) {
        // 一个实体（类）就关联到数据库中的一张表，此处表名为「GreenNews」（既类名）
        Entity news = schema.addEntity("GreenNews");
        // 你也可以重新给表命名
        // note.setTableName("NODE");

        // greenDAO 会自动根据实体类的属性值来创建表字段，并赋予默认值
        // 接下来你便可以设置表中的字段：
        news.addIdProperty();
        news.addStringProperty("newslist");
        // 与在 Java 中使用驼峰命名法不同，默认数据库中的命名是使用大写和下划线来分割单词的。
        news.addStringProperty("type");
    }

    public static void addStats(Schema schema) {
        Entity stat = schema.addEntity("GreenStat");
        stat.addIdProperty();
        stat.addStringProperty("statentity");
        stat.addStringProperty("statkind");
    }
}

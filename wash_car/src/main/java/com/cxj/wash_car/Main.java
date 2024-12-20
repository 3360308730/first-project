package com.cxj.wash_car;


import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/wash_car?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false", "root", "root")
                .globalConfig(builder -> {
                    builder.author("cxj") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .outputDir("C:\\Users\\www33\\Desktop\\first-project\\first-project\\wash_car\\src\\main\\java"); // 指定输出目录
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.SMALLINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder ->
                        builder.parent("com.cxj") // 设置父包名
                                .moduleName("wash_car") // 设置父包模块名

                )
                .strategyConfig(builder ->
                        builder.addInclude("car") // 设置需要生成的表名
                                .addTablePrefix("t_", "c_") // 设置过滤表前缀
                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
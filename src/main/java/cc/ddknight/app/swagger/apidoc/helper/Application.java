package cc.ddknight.app.swagger.apidoc.helper;

import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;

import java.net.URL;
import java.nio.file.Paths;

public class Application {
    public static void main(String[] args) throws Exception {
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .withOutputLanguage(Language.ZH)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();
        // swagger-ui.html页面中能找到此链接
        Swagger2MarkupConverter.from(new URL("http://localhost:9601/v2/api-docs"))
                .withConfig(config)
                .build()
                .toFile(Paths.get("./docs/asciidoc/generated/all"));
    }

}

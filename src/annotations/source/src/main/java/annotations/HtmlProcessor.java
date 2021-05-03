package annotations;

import com.google.auto.service.AutoService;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

@AutoService(Processor.class)
@SupportedAnnotationTypes(value = {"source.HtmlForm"})
public class HtmlProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        // сначала нужно получить типы с аннотаций source.HtmlForm

        Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(HtmlForm.class);

        // теперь нужно пройти по всем annotatedElements и сгенерировать html
        for (Element element : annotatedElements) {
            // получаем полный путь для генерации html
            String path = HtmlProcessor.class
                    .getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .getPath();

            // таким образом делаем названием класса название нашей формы, т.е. source.User.class -> source.User.html
            path = path.substring(1) + element.getSimpleName().toString() + ".html";

            // дальше делаем путь куда будем генерировать наш html
            Path out = Paths.get(path);

            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(out.toFile()));
                // получаем аннотацию со всеми параментрами, которое у неё проанатированны
                HtmlForm annotation = element.getAnnotation(HtmlForm.class);
                // собираем строку, т.е. получаем форму
                bufferedWriter.write("<form action='"+annotation.action()+" method='"+annotation.method()+"'/>");
                // закраваем поток
                bufferedWriter.close();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        return true;
    }
}

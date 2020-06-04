package edu.xpu.hcp;

import edu.xpu.hcp.bean.Student;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.HashSet;
import java.util.Set;

/**
 * 关于Spring容器管理Bean的过程以及加载模式：
 *      1、需要将bean的定义信息声明在Spring的配置文件中；
 *      2、需要通过Spring抽象出的各种Resource来指定对应的配置文件；
 *      3、需要显示声明一个Spring工厂，该工厂用来掌控我们在配置文件中所声明的各种bean以及bean之间的依赖关系与注入关系；
 *      4、需要定义一个配置信息读取器，该读取器用来读取之前所定义的bean配置文件信息；
 *      5、读取器的作用是读取我们所声明的配置文件信息，并且将读取后的信息装配到之前所声明的工厂当中；
 *      6、需要将读取器与工厂以及资源对象进行相应的关联处理；
 *      7、工厂所管理的全部对象装配完毕，可以供客户端直接调用，获取客户端想要使用的各种bean对象。
 *
 *  Spring对于Bean管理的核心组件：
 *      1、资源抽象；
 *      2、工厂；
 *      3、配置信息读取器。
 *
 *  BeanFactory是Spring Bean工厂最顶层的抽象。
 *
 *  关于Spring Bean实例注册的流程
 *      1、定义好Spring的配置文件；
 *      2、通过Resource对象将Spring配置文件进行抽象，抽象成一个具体的Resource对象（如ClassPathResource）;
 *      3、定义好将要使用的Bean工厂（各种BeanFactory）；
 *      4、定义好XmlBeanDefinitionReader对象，并将工厂对象作为参数传递进去，从而构建好二者之间的关联关系；
 *      5、通过XmlBeanDefinitionReader对象读取之前所抽取出的Resource对象；
 *      6、流程开始进行解析；
 *      7、针对Xml文件进行各种元素以及元素属性的解析，这里面，真正的解析是通过BeanDefinitionParserDelegate对象来完成的（委托模式）;
 *      8、通过BeanDefinitionParserDelegate对象在解析XML文件时，又使用到了模板方法设计模式（pre,process,posr）;
 *      9、当所有的bean标签元素都解析完毕后，开始定义一个BeanDefinition对象，该对象是一个非常重要的对象，里面容纳了一个Bean相关的所有属性；
 *      10、BeanDefinition对象创建完毕后，Spring又会创建一个BeanDefinitionHolder对象来持有这个BeanDefinition对象；
 *      11、BeanDefinitionHolder对象主要包含两部分内容：beanName和BeanDefinition;
 *      12、工厂会将解析出来的Bean信息存放到内部的一个ConcurrentHashMap中，该Map对象的键是beanName，值是BeanDefinition对象；
 *      13、调用Bean解析完毕的触发动作，从而触发相应的监听器的方法的执行（观察者模式）。
 */
public class SpringClient {
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("applicationContext.xml");
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);
        Student student = (Student)beanFactory.getBean("student");
        System.out.println(student);
    }
}

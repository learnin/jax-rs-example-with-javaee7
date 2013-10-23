package jaxrsexample.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
//import java.io.File;
//import org.jboss.shrinkwrap.resolver.api.maven.Maven;

public abstract class AbstractResourceIT {

    private static WebArchive archive;

    @Deployment
    public static WebArchive createDeployment() {
        if (archive == null) {
            archive = ShrinkWrap.create(WebArchive.class, "test.war")
                    .addPackages(true, "jaxrsexample")
                    // プロパティファイルやpom.xml記載のライブラリ等は以下のように指定してwarに入れる
                    //                    .addAsWebInfResource(new File("src/main/resources", "hoge.properties"), "classes/hoge.properties")
                    //                    .addAsLibraries(Maven.resolver()
                    //                    .loadPomFromFile("pom.xml").resolve("mysql:mysql-connector-java:5.1.23")
                    //                    .withTransitivity().asFile())
                    .addAsResource("META-INF/persistence.xml")
                    .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
            System.out.println(archive.toString(true));
        }
        return archive;
    }

    protected Client getClient() {
        try {
            return ClientBuilder.newBuilder()
                    .register(Class.forName("org.glassfish.jersey.media.multipart.MultiPartFeature"))
                    .register(Class.forName("org.glassfish.jersey.jackson.JacksonFeature"))
                    .build();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BooksResourceIT.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}

package com.nikolascharalambidis.stackoverflow.issue77894103.issue77894103;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.InstantiationStrategy;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.codehaus.plexus.PlexusContainer;

import com.nikolascharalambidis.stackoverflow.issue77894103.issue77894103.components.MyComponent;
import org.codehaus.plexus.component.annotations.Requirement;


@Mojo(
    name = "process-sources",
    defaultPhase = LifecyclePhase.PROCESS_SOURCES,
    instantiationStrategy = InstantiationStrategy.PER_LOOKUP,
    threadSafe = true
)
public class ProcessSourcesMojo extends AbstractMojo {

    @Component
    private PlexusContainer container;

    @Component
    private MyComponent myComponent;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        final boolean result = container.hasComponent(MyComponent.class, "myComponent");
        String name = myComponent.getClass().getName();

        getLog().info("### " + result);
        getLog().info("### name:" + name);
    }
}

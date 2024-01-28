package com.nikolascharalambidis.stackoverflow;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.InstantiationStrategy;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.codehaus.plexus.PlexusContainer;

import com.google.inject.Inject;
import com.nikolascharalambidis.stackoverflow.components.MyComponent;


@Mojo(
    name = "process-sources",
    defaultPhase = LifecyclePhase.PROCESS_SOURCES,
    instantiationStrategy = InstantiationStrategy.PER_LOOKUP,
    threadSafe = true
)
public class ProcessSourcesMojo extends AbstractMojo {

    @Component
    private PlexusContainer container;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        final boolean result = container.hasComponent(MyComponent.class, "myComponent");
        getLog().info("### " + result);
    }
}

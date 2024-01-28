package com.nikolascharalambidis.stackoverflow;


import com.soebes.itf.jupiter.extension.MavenCLIOptions;
import com.soebes.itf.jupiter.extension.MavenGoal;
import com.soebes.itf.jupiter.extension.MavenJupiterExtension;
import com.soebes.itf.jupiter.extension.MavenOption;
import com.soebes.itf.jupiter.extension.MavenProject;
import com.soebes.itf.jupiter.extension.MavenTest;
import com.soebes.itf.jupiter.maven.MavenExecutionResult;

import static com.soebes.itf.extension.assertj.MavenITAssertions.assertThat;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestMethodOrder;


@MavenJupiterExtension
public class ProcessSourcesMojoIT {

    @Nested
    @MavenProject
    @TestMethodOrder( MethodOrderer.OrderAnnotation.class )
    @MavenOption(MavenCLIOptions.NON_RECURSIVE)
    @MavenGoal("process-sources")
    class Simple {

        @MavenTest
        void success(MavenExecutionResult result) {
            assertThat(result).isSuccessful();
            assertThat(result).out().plain().contains("[INFO] ### true");
        }
    }
}
package com.nikolascharalambidis.stackoverflow.issue77894103;


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
class ProcessSourcesMojoIT {

    @Nested
    @MavenProject
    @MavenOption(MavenCLIOptions.NON_RECURSIVE)
    @MavenOption(MavenCLIOptions.VERBOSE)
//    @MavenOption(MavenCLIOptions.SHOW_VERSION)
    @MavenOption(MavenCLIOptions.BATCH_MODE)
    @MavenGoal("process-sources")
    class Simple {

        @MavenTest
        void success(MavenExecutionResult result) {
            assertThat(result).isSuccessful();
            assertThat(result).out().info().contains("### true");
        }
    }
}
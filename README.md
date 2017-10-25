Spring Boot @ConfigurationProperties sample
===========================================
Based on https://github.com/bijukunjummen/try-spring-boot-config

Demonstrates bug in boot 2.0.0.M5 . If you switch pom version for spring-boot-starter-parent to 2.0.0.M5 and update SamplePropertyLoadingTest and run then it fails. But it worked in 1.5.1.RELEASE.

Note that it does work in 2.0.0.M5 if you remove the TestPropertySource annotation from the test.

So the bug is that maps aren't read correctly from yml files when using TestPropertySource. Properties files don't seem to have this problem, just yaml.

I don't think the nesting in this example is important as can construct the same problem around the example at https://stackoverflow.com/questions/24917194/spring-boot-inject-map-from-application-yml

The error encountered is:

org.springframework.core.convert.ConverterNotFoundException: No converter found capable of converting from type [java.lang.String] to type [prop.ActivitiProperty]

And this happens in all of the boot 2 milestones.
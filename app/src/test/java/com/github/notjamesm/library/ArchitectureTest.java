package com.github.notjamesm.library;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchitectureTest {

    @Test
    public void domainDoesNotHaveExternalDependencies() {
        ArchRule rule = classes().that().resideInAPackage("..domain..").should()
                .onlyDependOnClassesThat().resideInAnyPackage("..domain..", "..java..");

        rule.check(importedClasses);
    }

    @Test
    public void useCasesOnlyDependOnDomain() {
        ArchRule rule = classes().that().resideInAPackage("..usecases..").should()
                .onlyDependOnClassesThat().resideInAnyPackage("..domain..", "..java..", "..usecases..",
                        "..io.vavr.control..", "..org.springframework..", "..org.slf4j..");

        rule.check(importedClasses);
    }

    private final JavaClasses importedClasses = new ClassFileImporter().importPackages("com.github.notjamesm.library");
}

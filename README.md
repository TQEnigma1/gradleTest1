# Our Template Comrade
This repository serves as guidance for starting on a new project

It is not directly pastable, to start generate a template from the [Fabric Template Mod Generator](https://fabricmc.net/develop/template/)

Use the following, replacing template with your chosen mod name:
- Name: StarlitTemplate
- Package Name: com.starlitmc.starlittemplate
- Version: 1.20.1
- [x] Kotlin Programming Language
- [ ] Data Generation
- [ ] Split client and common sources

Unzip your new template to wherever you deem, then open it in Intellij Idea.

- delete the .github folder.
- replace build.gradle with the one from this repo, yes you can just paste it over
- do the same for gradle.properties
- adjust your org.gradle.jvmargs=-Xmx1G appropriately
- gradle -> settings -> change both "Build and run using" and "Run tests using" to Intellij IDEA
- gradle should be prompting you to refresh, do that
- probably also copy the LICENSE file to the same place as this repo
- finito,  youre now ready to get started


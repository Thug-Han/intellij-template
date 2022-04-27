package other.designpattern

import com.android.tools.idea.wizard.template.Language
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import other.designpattern.singleton.Singleton

/**
 * @Date   : 2022/4/22
 **/
fun RecipeExecutor.designPatternRecipe(
    moduleData: ModuleTemplateData,
    activityClass: String,
    packageName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    // 是创建 JAVA的还是Kotlin的文件，Language.Java  Language.Kotlin
    // 只要在widgets中使用了LanguageWidget()  这里都能获取选择的语言projectData.language.extension
    val ktOrJavaExt = projectData.language.extension

    val singleTon: String
    // 根据是java还是kotlin创建不同class内容
    if (ktOrJavaExt == Language.Kotlin.extension) {
        singleTon = Singleton.singleTonKt(activityClass, packageName)
    } else {
        singleTon = Singleton.singleTonJava(activityClass, packageName)
    }
    // 创建文件
    val file = srcOut.resolve("$activityClass.${ktOrJavaExt}")
    save(singleTon, file)
    // 打开文件
    open(file)
}
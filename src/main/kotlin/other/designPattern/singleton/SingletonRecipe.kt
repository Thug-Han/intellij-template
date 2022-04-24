package other.designPattern.singleton

import com.android.tools.idea.wizard.template.Language
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor

/**
 * @Date   : 2022/4/22
 * @Desc   :
 **/
fun RecipeExecutor.singletonRecipe(
    moduleData: ModuleTemplateData,
    activityClass: String,
    packageName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    // 是创建 JAVA的还是Kotlin的文件，Language.Java  Language.Kotlin
    val ktOrJavaExt = Language.Java

    val singleTonKt = singleTonKt(activityClass, packageName)

    save(singleTonKt, srcOut.resolve("$activityClass.${ktOrJavaExt}"))
}
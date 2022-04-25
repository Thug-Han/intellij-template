package other.designpattern.singleton

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import other.designpattern.designPatternRecipe

/**
 * @Date   : 2022/4/22
 **/
val designPatternTemplate
    get() = template {
        name = "singleton"
        description = "生成一个内部静态内部类的singleton"
        minApi = MIN_API

        // 显示在哪个类目
        category = Category.Other
        formFactor = FormFactor.Mobile
        // 显示在哪些位置,就是NewActivity
        screens = listOf(
            WizardUiContext.ActivityGallery,
            WizardUiContext.MenuEntry,
            WizardUiContext.NewProject,
            WizardUiContext.NewModule
        )

        val activityClass = stringParameter {
            name = "Class Name"
            default = "Singleton"
            help = "输入类的名字"
            constraints = listOf(Constraint.NONEMPTY)
        }

        val packageName = defaultPackageNameParameter

        // 一些控件
        widgets(
            // 文字控件
            TextFieldWidget(activityClass),
            // 包名控件
            PackageNameWidget(packageName)
        )

        recipe = { data: TemplateData ->
            designPatternRecipe(
                data as ModuleTemplateData,
                activityClass.value,
                packageName.value
            )
        }

    }
val defaultPackageNameParameter
    get() = stringParameter {
        name = "Package name"
        visible = { !isNewModule }
        default = "com.mycompany.myapp"
        constraints = listOf(Constraint.PACKAGE)
        suggest = { packageName }
    }


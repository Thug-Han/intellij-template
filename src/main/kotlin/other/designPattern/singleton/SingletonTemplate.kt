package other.designPattern.singleton

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API

/**
 * @Date   : 2022/4/22
 * @Desc   :
 **/
val singletonTemplate
    get() = template {
//        revision = 1
        name = "singleton"
        description = "生成一个内部静太类singleton"
        minApi = MIN_API
//        minBuildApi = MIN_API

        category = Category.Other
        formFactor = FormFactor.Mobile
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

        widgets(
            TextFieldWidget(activityClass),
            PackageNameWidget(packageName)
        )

        recipe = { data: TemplateData ->
            singletonRecipe(
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


package other.designpattern

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API

/**
 * @Date   : 2022/4/22
 **/
val designPatternTemplate
    get() = template {
        name = "DesignPattern"
        description = "Select a design pattern you want to generate"
        minApi = MIN_API

        // 显示在哪个类目
        category = Category.Other
        formFactor = FormFactor.Mobile
        // 显示在哪些位置,就是,感觉必须要选择一个,不然不会展示,就选这个不知道具体在哪展示的,参考其它的Other中的都是写的这个,
        // 还有其它可选的,如果是Activity类的建议增加 WizardUiContext.ActivityGallery
        screens = listOf(
            WizardUiContext.MenuEntry,
        )

        val activityClass = stringParameter {
            name = "Class Name"
            default = "Singleton"
            help = "Enter the name of the class"
            constraints = listOf(Constraint.NONEMPTY)
        }

        val packageName = stringParameter {
            name = "Package name"
            visible = { !isNewModule }
            default = "com.thughan.design"
            constraints = listOf(Constraint.PACKAGE)
            suggest = { packageName }
        }

        // 一些控件
        widgets(
            // 生成文件语言控件
            LanguageWidget(),
            // 文字控件
            TextFieldWidget(activityClass),
            // 包名控件
            PackageNameWidget(packageName),
        )
        // 输出文件
        recipe = { data: TemplateData ->
            designPatternRecipe(
                data as ModuleTemplateData,
                activityClass.value,
                packageName.value
            )
        }

    }

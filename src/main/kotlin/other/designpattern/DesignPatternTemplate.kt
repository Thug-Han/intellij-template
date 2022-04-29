package other.designpattern

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import other.designpattern.singleton.SingleTonCategory

/**
 * @Date   : 2022/4/22
 **/
val designPatternTemplate
    get() = template {
        name = "DesignPattern"
        // 必写不然不显示
        description = "Select a design pattern you want to generate"
        minApi = MIN_API

        // 显示在哪个类目
        category = Category.Other
        formFactor = FormFactor.Mobile
        // 显示在哪些位置,就是,感觉必须要选择一个,不然不会展示,就选这个不知道具体在哪展示的,参考其它的Other中的都是写的这个,
        // 还有其它可选的,如果是Activity类的建议增加 WizardUiContext.ActivityGallery,会显示在Activity->Gallery中.
        screens = listOf(
            WizardUiContext.MenuEntry,
        )

        val designPattern = enumParameter<DesignCategory> {
            name = "Select a design pattern"
            default = DesignCategory.SINGLETON
        }

        val singleTonCategory = enumParameter<SingleTonCategory> {
            name = "Select a SingleTon type"
            default = SingleTonCategory.STATIC
            // 决定这个条目是否展示
            visible = { designPattern.value == DesignCategory.SINGLETON }
        }

        val activityClass = stringParameter {
            name = "Class Name"
            default = "Singleton"
            help = "Enter the name of the class"
            constraints = listOf(Constraint.NONEMPTY)
        }

        val packageName = stringParameter {
            name = "Package name"
            default = "com.thughan.design"
            constraints = listOf(Constraint.PACKAGE)
            suggest = { packageName }
        }

        // 一些控件
        widgets(
            // 选择生成的设计模式种类
            EnumWidget(designPattern),
            EnumWidget(singleTonCategory),
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

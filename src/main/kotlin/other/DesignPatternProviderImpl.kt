package other

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import other.designpattern.singleton.designPatternTemplate

/**
 * @Date : 2022/4/22
 * @Desc :
 */
class DesignPatternProviderImpl : WizardTemplateProvider() {
    override fun getTemplates(): List<Template> = listOf(
        designPatternTemplate
    )
}
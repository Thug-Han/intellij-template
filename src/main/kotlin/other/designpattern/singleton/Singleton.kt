package other.designpattern.singleton


object Singleton {
    fun singleTonJava(activityClass: String, packageName: String) =
        """
package $packageName;

public class $activityClass {

    private $activityClass()
    {

    }

    public static $activityClass getInstance()
    {
        return SingletonHolder.SINGLETON;
    }

    private static
    class SingletonHolder {
        private static final $activityClass SINGLETON = new $activityClass();
    }

}
"""

    fun singleTonKt(activityClass: String, packageName: String) =
        """
            package $packageName

            object $activityClass {

            }
"""

}

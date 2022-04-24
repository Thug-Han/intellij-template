package other.designPattern.singleton

fun singleTonKt(
    packageName: String,
    activityClass: String
) =
    """
package ${packageName};


public class $activityClass {

    private $activityClass() {

    }

    public static $activityClass getInstance() {
        return SingletonHolder.SINGLETON;
    }

    private static class SingletonHolder {
        private static final $activityClass SINGLETON = new $activityClass();
    }

} 
"""

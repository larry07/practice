https://www.cnblogs.com/alongwaytogo/p/5111516.html

 .H 文件中每个全局变量都加上了xxx_EXT 的前缀  xxx代表模块的名字。   
 定义全局宏。
 ```
    #ifdef xxx_GLOBALS
    #define xxx_EXT
    #else
    #define xxx_EXT extern
    #endif
 ```

该模块的.C 文件中有以下定义：

    #define xxx_GLOBALS
    ＃include "includes.h"
如
    #ifdef OS_GLOBALS
    #define OS_EXT
    #else
    #define OS_EXT extern
    #endif
    OS_EXT INT32U OSIdleCtr;
    OS_EXT INT32U OSIdleCtrRun;
    OS_EXT INT32U OSIdleCtrMax;
同时，uCOS_II.H 有中以下定义：

    #define OS_GLOBALS
    ＃i nclude “includes.h”

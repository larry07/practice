#ifdef OS_GLOBALS
    #define OS_EXT
#else
    #define OS_EXT extern
#endif // OS_GLOBALS
OS_EXT void Func(void);
OS_EXT int  g;


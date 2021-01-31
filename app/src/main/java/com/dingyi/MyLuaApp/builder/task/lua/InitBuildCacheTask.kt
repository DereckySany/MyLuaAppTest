package com.dingyi.MyLuaApp.builder.task.lua

import com.androlua.LuaUtil
import com.dingyi.MyLuaApp.builder.LuaBuilderCache
import com.dingyi.MyLuaApp.builder.task.LuaTask
import com.dingyi.MyLuaApp.utils.toFile

class InitBuildCacheTask: LuaTask() {

    override fun doAction(vararg arg: Any) {
        val luaBuilderCache=arg[0] as LuaBuilderCache;
        val activity=activity!!

        luaBuilderCache.cacheDir.toFile().mkdirs();
        luaBuilderCache.buildDir.toFile().mkdirs();

        if (!luaBuilderCache.cacheLibDir.toFile().isDirectory) { //加载lua lib
            val soPath="/data/data/${activity.packageName}/lib/"
            val toPath=luaBuilderCache.cacheLibDir+"/armeabi-v7a/"
            toPath.toFile().mkdirs()
            LuaUtil.copyDir(soPath,toPath)
            sendMessage("init lua lib")
        }

        if (!luaBuilderCache.cacheLuaDir.toFile().isDirectory) { //加载lua
            val soPath="/data/data/${activity.packageName}/app_lua/"
            val toPath=luaBuilderCache.cacheLuaDir
            toPath.toFile().mkdirs()
            LuaUtil.copyDir(soPath,toPath)
            sendMessage("init lua lib")
        }

        //加载res
        if (!luaBuilderCache.cacheResDir.toFile().isDirectory || !luaBuilderCache.cacheArscPath.toFile().isFile || !luaBuilderCache.cacheAxmlPath.toFile().isFile) { //��ѹlua
            val defaultZipPath="/data/data/${activity.packageName}/assets/res/build/defaultRes.zip"
            LuaUtil.unZip(defaultZipPath,luaBuilderCache.cacheDir)
            sendMessage("init res")
        }


        if (luaBuilderCache.projectIconPath.toFile().isFile) {
            LuaUtil.copyFile(luaBuilderCache.projectIconPath,luaBuilderCache.cacheResDir+"/drawable/"+luaBuilderCache.projectIconPath.toFile().name)
        }

        if (luaBuilderCache.projectWelcomePath.toFile().isFile) {
            LuaUtil.copyFile(luaBuilderCache.projectIconPath,luaBuilderCache.cacheResDir+"/drawable/"+luaBuilderCache.projectWelcomePath.toFile().name)
        }

    }
}
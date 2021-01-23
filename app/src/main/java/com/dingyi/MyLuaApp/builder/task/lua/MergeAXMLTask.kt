package com.dingyi.MyLuaApp.builder.task.lua

import cn.wjdiankong.main.ParserChunkUtils
import cn.wjdiankong.main.XmlEditor
import com.androlua.LuaUtil
import com.dingyi.MyLuaApp.activitys.BaseActivity
import com.dingyi.MyLuaApp.builder.LuaBuilderCache
import com.dingyi.MyLuaApp.builder.task.LuaTask
import com.dingyi.MyLuaApp.utils.readBytes
import com.dingyi.MyLuaApp.utils.writeBytes
import java.io.FileInputStream

class MergeAXMLTask: LuaTask() {
    override fun doAction(vararg arg: Any) {
        val luaBuilderCache=arg[0] as LuaBuilderCache;
        val activity=arg[1] as BaseActivity;

        val luaConfig=luaBuilderCache.getLuaConfigs();

        ParserChunkUtils.xmlStruct.byteSrc = readBytes(FileInputStream(luaBuilderCache.cacheAxmlPath)) //����axml

        XmlEditor.modifyAttr("manifest","package","package",luaConfig["packagename"]) //���ĺͰ�����ص�
        XmlEditor.modifyAttr("provider","exported","authorities",luaConfig["packagename"])

        //���Ȩ����ص�



        writeBytes(luaBuilderCache.buildAxmlOutPath,ParserChunkUtils.xmlStruct.byteSrc)

    }
}
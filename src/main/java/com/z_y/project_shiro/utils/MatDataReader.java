package com.z_y.project_shiro.utils;

import com.jmatio.io.MatFileReader;
import com.jmatio.types.MLArray;
import com.jmatio.types.MLDouble;

import java.io.IOException;

public class MatDataReader
{
    private String path;
    private MatFileReader reader;

    public MatDataReader(String path) throws IOException
    {
        this.path = path;
        this.reader = new MatFileReader(path);
    }

    public double[][] getFilterData()
    {
        return this.getData("filter_save");
    }

    public double[][] getOriginalData()
    {
        return this.getData("original_save");
    }

    public double[][] getTimeData()
    {
        return this.getData("time_save");
    }

    public double[][] getData(String dataName)
    {
        MLArray mlArray = this.reader.getMLArray(dataName);//参数为配置文件读取出来后的变量名
        MLDouble mlDoubleArray = (MLDouble) mlArray;//转换为MLDouble类型
        double[][] array = mlDoubleArray.getArray();
        return array;
    }
}

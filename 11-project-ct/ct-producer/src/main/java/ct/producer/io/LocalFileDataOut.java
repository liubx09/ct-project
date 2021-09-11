package ct.producer.io;

import ct.common.bean.DataOut;

import java.io.*;

/**
 * 本地文件输出
 */
public class LocalFileDataOut implements DataOut {
    private PrintWriter writer = null;

    public LocalFileDataOut(String path){
        setPath(path);
    }

    @Override
    public void setPath(String path) {
        try {
            writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void write(Object data) throws Exception {
       write(data.toString());
    }

    /**
     * 将数据字符串生产到文件中
     * @param data
     * @throws Exception
     */
    @Override
    public void write(String data) throws Exception {
        writer.println(data);
        writer.flush();
    }

    @Override
    public void close() throws IOException {
        if(writer != null){
            writer.close();
        }
    }
}
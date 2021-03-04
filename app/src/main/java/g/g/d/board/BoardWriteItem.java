package g.g.d.board;

import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

public class BoardWriteItem {
    private String subject;
    private String name;
    private String content;
    private String password;
    private Bitmap file;
    private String filename;

    // Server에서 보낼 때 만듬
    public BoardWriteItem(String subject, String name, String content, String password, Bitmap file) {
        this.subject = subject;
        this.name = name;
        this.content = content;
        this.password = password;
        this.file = file;
        this.filename = this.subject + "__" + this.name + "__" + this.content + ".jpg";
    }

    static public String boundary = "----BoardAttribute";
    static private String startBoundary= "--" + boundary + "\r\n";
    static private String endBoundary = "\r\n--" + boundary + "--\r\n";

    // Transform multipart/form-data
    private byte[] exportString(String key, String value)
    {
        StringBuilder builder = new StringBuilder();
        builder.append(startBoundary);
        builder.append("Content-Disposition: form-data; name=\"" + key + "\"\r\n");
        builder.append("\r\n");
        builder.append(value);
        builder.append("\r\n");
        String string = builder.toString();
        byte[] result = string.getBytes(StandardCharsets.UTF_8);

        /*
        이걸 했을 시 결과

        ------BoardAttribute
        Content-Disposition: form-data; name="key"

        value
         */

        return result;
    }
    private byte[] exportFile()
    {
        StringBuilder builder = new StringBuilder();

        builder.append(startBoundary);
        builder.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + this.filename + "\"\r\n");
        builder.append("Content-Type: image/jpeg\r\n");
        builder.append("\r\n");
        String prefixString = builder.toString();
        byte[] prefix = prefixString.getBytes(StandardCharsets.UTF_8);

        /*
        이걸 했을 시 결과

        ------BoardAttribute
        Content-Disposition: form-data="file"; filename="filename에 써있는거.jpg"
        Content-Type: image/jpeg

         */

        byte[] content = new byte[0];
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            file.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            content = byteArrayOutputStream.toByteArray();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
        /*
        이걸 했을 시 결과

        Bitmap 안에 있는 내용
         */


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(prefix);
            byteArrayOutputStream.write(content);
        } catch(Exception e)
        {
            e.printStackTrace();
        }
        byte[] result = byteArrayOutputStream.toByteArray();
        /*
        이걸 했을 시 결과

        ------BoardAttribute
        Content-Disposition: form-data="file"; filename="filename에 써있는거.jpg"
        Content-Type: image/jpeg

        Bitmap 안에 있는 내용
         */

        return result;
    }


    public byte[] export() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bytes = exportString("bsubject", subject);
            byteArrayOutputStream.write(bytes);
            /*
            ------BoardAttribute
            Content-Disposition: form-data; name="bsubject"

            bsubject 내용
            */
            bytes = exportString("bname", name);
            byteArrayOutputStream.write(bytes);
            /*
            ------BoardAttribute
            Content-Disposition: form-data; name="bname"

            bname 내용
            */
            bytes = exportString("bcontent", content);
            byteArrayOutputStream.write(bytes);
            /*
            ------BoardAttribute
            Content-Disposition: form-data; name="bcontent"

            bcontent 내용
            */
            bytes = exportString("bpw", password);
            byteArrayOutputStream.write(bytes);
            /*
            ------BoardAttribute
            Content-Disposition: form-data; name="bpw"

            bpw 내용
            */
            //bytes = exportString("bfile", filename);
            //byteArrayOutputStream.write(bytes);
            /*
            ------BoardAttribute
            Content-Disposition: form-data; name="bfile"

            filename 내용
            */
            bytes = exportFile();
            byteArrayOutputStream.write(bytes);
            /*
            ------BoardAttribute
            Content-Disposition: form-data="file"; filename="filename에 써있는거.jpg"
            Content-Type: image/jpeg

            Bitmap 안에 있는 내용
            */

            bytes = endBoundary.getBytes(StandardCharsets.UTF_8);
            byteArrayOutputStream.write(bytes);
            /*

            ------BoardAttribute--
             */
        } catch(Exception e)
        {
            e.printStackTrace();
        }
        byte[] result = byteArrayOutputStream.toByteArray();
        /*
            ------BoardAttribute
            Content-Disposition: form-data; name="bsubject"

            bsubject 내용
            ------BoardAttribute
            Content-Disposition: form-data; name="bname"

            bname 내용
            ------BoardAttribute
            Content-Disposition: form-data; name="bcontent"

            bcontent 내용
            ------BoardAttribute
            Content-Disposition: form-data; name="bpw"

            bpw 내용
            ------BoardAttribute
            Content-Disposition: form-data; name="bfile"

            filename 내용
            ------BoardAttribute
            Content-Disposition: form-data="file"; filename="filename에 써있는거.jpg"
            Content-Type: image/jpeg

            Bitmap 안에 있는 내용

            ------BoardAttribute--
        */

        return result;
    }
}

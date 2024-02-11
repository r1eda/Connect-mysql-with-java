import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// import com.mysql.cj.jdbc.result.ResultSetMetaData;


public class Test {
    static String dd ;
    
    public static void connection() {
        // تحديد معلومات الاتصال بقاعدة البيانات
        String url = "jdbc:mysql://localhost/databace?serverTimeZone=UTC";
        String user = "Reda";
        String password = "1234";

        try {
            // إنشاء الاتصال
            Connection c = DriverManager.getConnection(url, user, password);

            // قم بالتعامل مع الاتصال هنا (إجراء الاستعلامات أو العمليات الأخرى)
            Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet r = s.executeQuery("SELECT * FROM student");
            // ResultSetMetaData rm = r.getMetaData();
            for (int i=1;i<=r.getMetaData().getColumnCount();i++){
                System.out.print(String.format("%-15s",r.getMetaData().getColumnName(i)));
            };
            
            System.out.println("");
            // استخدم النتائج هنا (قم بطباعتها كمثال)
            while (r.next()) {
                dd = r.getString("FName");
                int studentId = r.getInt("Id");
                String studentName = r.getString("FName");
                String LName = r.getString("LName");
                String City = r.getString("City");
                //*  قم بالتعامل مع البيانات كما تحتاج
                // System.out.println("Student ID: " + studentId + ", Student Name: " + studentName+", LName: "+LName+", City :"+City );
                
                System.out.println(String.format("%-15s%-15s%-15s%-15s",
                studentId,
                studentName,
                LName,
                City));

                
            }
            
            // أغلق Statement و ResultSet و Connection عند الانتهاء
            r.close();
            s.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

static  String d (){ 
    return dd;
  }
}
/*
 *          r.next();//صف اول
            r.next(); // صف ثاني
            r.absolute(3);//ينتقل لعدد الصف اللي دخله 
            r.relative(-2);//تحرك المؤشر باتجاه الخلف
            r.previous();//عكس النكست يعني ترجع خطوه للوراء مثلا
            r.first();//ينطيك اول صف
            r.last();//ينطيك اخر صف
            r.beforeFirst();//ترجع المؤشر الى ما قبل اول صف
            r.next();//هذه قبل لاتخلي هو مكانه قبل الصفوف شلو ن الداله القبلهة
            r.afterLast();//المركز ما بعد الاخير
            //*  ذن الجوه يفيدن للتحقق من مكان المؤشر
            //*يفيدن بالشروط 
            r.isFirst();
            r.isLast();
            r.isBeforeFirst();//ماقبل البداية
            r.isAfterLast();//مابعد النهاية 
            Ex : 
            r.next();//صف اول
          
            int studentId1 = r.getInt("Id");
            System.out.println("Student ID: " + studentId1);
 */
/*
 * while (r.next()) {
                int studentId = r.getInt("Id");
                String studentName = r.getString("FName");
                String LName = r.getString("LName");
                //*  قم بالتعامل مع البيانات كما تحتاج
                System.out.println("Student ID: " + studentId + ", Student Name: " + studentName+", LName: "+LName );
            }
 *  for(r.first();!r.isAfterLast();r.next())
           {
            int studentId = r.getInt("Id");
            String studentName = r.getString("FName");
            String LName = r.getString("LName");
            //* قم بالتعامل مع البيانات كما تحتاج
            System.out.println("Student ID: " + studentId + ", Student Name: " + studentName+", LName: "+LName );
        }
 */
/*
 *  while (r.next()) {
                int studentId = r.getInt("Id");
                String studentName = r.getString("FName");
                String LName = r.getString("LName");
                //*  هاي هنا سويت تنسيق للنص اليظهر و الشارحة معناها من اليسار يبدي و 15% يعني المسافة بينهن و الاس يعني سترنك
                System.out.println(String.format("%-15s %-15s %-15s",
                
                
                  studentId ,  studentName,LName ));
            }
 */
/*
 * int i=0;
 * 
 *  while (r.next()) {
 * i++;
 *  r.getRow();//ينطي الرو اللي انه بي
 * int numcount = r.getRow();
                int studentId = r.getInt("Id");
                String studentName = r.getString("FName");
                String LName = r.getString("LName");
                System.out.println(String.format("%-15s %-15s %-15s",
                  studentId ,  studentName,LName ));
            }
            System.out.println("The count of rows :"+i);//كيف نعرف عدد الصفوف
            System.out.println("The count of rows :"+r.getRow());
             System.out.println("The count of rows :"+numcount);
 */
/*
 //*الاظافة
            r.moveToInsertRow();
            r.updateInt("id", 18);//هنا اذا شغلته مرتين راح يضيف نفس البرايمري كي مرتين وهذه ما يجوز فلازم تبدله
            r.updateString("FName", "NumNum");
            r.updateString("LName", "Num");
            r.updateString("City", "Space");
            r.insertRow();
           
        //*التحديث

        int i=0;
 
  while (r.next()) {
  //*الحذف
   if(r.getRow()== 4){
//*     r.deleteRow();
//*      continue ;
//*     }
  r.getRow();//ينطي الرو اللي انه بي
  i = r.getRow();
  if (r.getRow() == 3){//تحديث على الصف الثاني 
    r.updateInt("id", 3);//هنا من يحدث 3 مثلا خلا 6 راح يتغير مكانه بقاعده البيانات 
    r.updateString("FName", "Jaffer");
    r.updateRow();//يطبق التعديلات
  }

                int studentId = r.getInt("Id");
                String studentName = r.getString("FName");
                String LName = r.getString("LName");
                System.out.println(String.format("%-15s %-15s %-15s",
                  studentId ,  studentName,LName ));
            }
            System.out.println("The count of rows :"+ i);//كيف نعرف عدد الصفوف
            System.out.println( "The count Column: "+r.getMetaData().getColumnCount());//ينطيك عدد الاعمدة
            System.out.println( "The Name Column: "+r.getMetaData().getColumnName(1));//تنطيك اسم العمود
            for(int f=1; f<=r.getMetaData().getColumnCount();f++)
            {
                System.out.println( "The Column  Name : "+r.getMetaData().getColumnName(f)+", ");
                System.out.println( "The Table Name: "+r.getMetaData().getTableName(f)+", ");
                System.out.println( "The Column Type: "+r.getMetaData().getColumnType(f)+", ");

            }
            //*  r.getMetaData().بيهة هواي سوالف
 */
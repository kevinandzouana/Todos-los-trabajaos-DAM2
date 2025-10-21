package example.newspapercrud.dao.Utilities;

public class SQLQueries {
    public static final String GET_ALL_ARTICLES = "SELECT a.id, a.name_article, a.id_newspaper, t.id AS type_id, t.description AS type_description FROM article a INNER JOIN type t ON a.id_type = t.id;";
    public static final String GET_ALL_TYPES = "select * from type";
    public static final String GET_ALL_READERS = "select * from reader where id > 0";
    public static final String GET_ALL_READERS_BY_ARTICLEID = "select * from reader where id in (select id_reader from readarticle where id_article = ?)";
    public static final String GET_READER_BY_ID = "select * from reader where id = ?";
    public static final String GET_ALL_NEWSPAPERS = "select * from newspaper";
    public static final String GET_ALL_NEWSPAPERS_BY_READERID= "select * from newspaper where id in (select id_newspaper from subscribe where id_reader = ?)";
    public static final String GET_TYPE_BY_ID = "select * from type where id = ?";
    public static final String GET_NEWSPAPER_BY_ID = "select * from newspaper where id = ?";
    public static final String GET_READARTICLE = "select * from readarticle where id_article = ? and id_reader = ?";
    public static final String GET_READARTICLES_BY_ARTICLEID= "select 0, id_article, 0, avg(rating) from readarticle where id_article = ?";
    public static final String GET_CREDENTIAL = "select * from login where userlog = ?";
    public static final String INSERT_ARTICLE = "insert into article (name_article,id_type,id_newspaper) values (?,?,?)";
    public static final String UPDATE_ARTICLE = "update article set name_article = ?, id_type = ?, id_newspaper = ? where id = ?";
    public static final String DELETE_ARTICLE = "delete from article where id = ?";
    public static final String DELETE_ARTICLE_READARTICLES = "delete from readarticle where id_article = ?";
    public static final String INSERT_READARTICLE = "insert into readarticle (id_article,id_reader,rating) values (?,?,?)";
    public static final String DELETE_READER = "delete from reader where id = ?";
    public static final String DELETE_READER_READARTICLES = "delete from readarticle where id_reader = ?";
    public static final String DELETE_READER_SUBSCRIPTIONS = "delete from subscribe where id_reader = ?";
    public static final String DELETE_READER_LOGIN = "delete from login where id_reader = ?";
    public static final String DELETE_READARTICLE = "delete from readarticle where id_reader = ? and id_article = ?";
    public static final String UPDATE_READARTICLE = "update readarticle set rating = ? where id_article = ? and id_reader = ?";

    public static final String INSERT_CREDENTIAL = "insert into user_login (username,password,patient_id,doctor_id) values (?,?,?,?)";

    public static final String DELETE_CREDENTIAL = "delete from user_login where patient_id = ?";
    public static final String GET_GROUPED_PAYMENTS = "select sum(amount),patient_id from patient_payments group by patient_id";
    public static final String GET_ALL_PAYMENTS = "select * from patient_payments";
    public static final String GET_MEDICAL_RECORDS = "select * from medical_records where patient_id = ?";
    public static final String GET_PRESCRIBED_MEDICATIONS = "select * from prescribed_medications where record_id = ?";

    public static final String DELETE_PATIENT_PRESCRIBED_MEDICATIONS = "delete pm from prescribed_medications pm join medical_records mr on pm.record_id = mr.record_id where mr.patient_id = ?";
    public static final String INSERT_MEDICAL_RECORD = "insert into medical_records (patient_id,doctor_id,diagnosis,admission_Date) values (?,?,?,?)";
    public static final String INSERT_MEDICATION = "insert into prescribed_medications (record_id,medication_name,dosage) values (?,?,?)";
    public static final String UPDATE_MEDICAL_RECORD = "update medical_records set doctor_id = ?, diagnosis = ?, admission_Date = ? where record_id = ?";
    public static final String GET_ALL_MEDICATIONS = "select t1.* from prescribed_medications t1 join" +
            "(select medication_name, min(prescription_id) as first_id from prescribed_medications group by medication_name)" +
            " t2 on t1.medication_name = t2.medication_name and t1.prescription_id = t2.first_id";
    public static final String GET_ALL_DOCTORS_NAMES = "select name from doctors";
    public static final String GET_ALL_DOCTORS = "select * from doctors";
    public static final String DELETE_PATIENT_MEDICAL_RECORDS = "delete from medical_records where patient_id = ?";
    public static final String DELETE_PATIENT_PAYMENTS = "delete from patient_payments where patient_id = ?";
    public static final String DELETE_PRESCRIBED_MEDICATIONS = "delete from prescribed_medications where record_id = ?";
    public static final String DELETE_PATIENT_APPOINTMENTS = "delete form appointments where patient_id = ?";

    private SQLQueries() {
    }
}

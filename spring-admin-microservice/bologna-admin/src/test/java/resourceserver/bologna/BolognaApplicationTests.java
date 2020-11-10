package resourceserver.bologna;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import resourceserver.model.blog.PageContent;
import resourceserver.model.blog.Pages;
import resourceserver.model.embedable.*;
import resourceserver.model.university.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BolognaApplicationTests {

	@Test
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		////////  UNİVERSİTY  ////////
		University university1 = new University();
		university1.setName("Mühendislik Fakültesi");
		university1.setAddress("Konya/TÜRKİYE");
		university1.setAbout("Konya'nın en prestijli Fakültesi");
		university1.setType(University_type.fakulte);
		////////    U-END     ////////

		//////// MAJOR DEPARTMENTS  ///////////
		UniversityMajorDepartment umd1 = new UniversityMajorDepartment();
		umd1.setMajor_department_name("Bilgisayar Mühendisliği(ANADAL)");
		umd1.setUniversity(university1);

		UniversityMajorDepartment umd2 = new UniversityMajorDepartment();
		umd2.setMajor_department_name("Yazılım Mühendisliği(ANADAL)");
		umd2.setUniversity(university1);
		////////    MD-END     ////////

		////////  TYYC  ///////////
		TYYC tyyc1 = new TYYC(); tyyc1.setTyyc_content("TÜRKİYE YÜKSEKÖĞRETİM YETERLİLİKLER ÇERÇEVESİ 1");// tyyc1.setId(0);
		TYYC tyyc2 = new TYYC(); tyyc2.setTyyc_content("TÜRKİYE YÜKSEKÖĞRETİM YETERLİLİKLER ÇERÇEVESİ 2");// tyyc2.setId(1);
		TYYC tyyc3 = new TYYC(); tyyc3.setTyyc_content("TÜRKİYE YÜKSEKÖĞRETİM YETERLİLİKLER ÇERÇEVESİ 3");// tyyc3.setId(2);
		TYYC tyyc4 = new TYYC(); tyyc4.setTyyc_content("TÜRKİYE YÜKSEKÖĞRETİM YETERLİLİKLER ÇERÇEVESİ 4");// tyyc4.setId(3);
		TYYC tyyc5 = new TYYC(); tyyc5.setTyyc_content("TÜRKİYE YÜKSEKÖĞRETİM YETERLİLİKLER ÇERÇEVESİ 5");// tyyc5.setId(4);
		TYYC tyyc6 = new TYYC(); tyyc6.setTyyc_content("TÜRKİYE YÜKSEKÖĞRETİM YETERLİLİKLER ÇERÇEVESİ 6");// tyyc6.setId(5);
		//////// TYYC-END ////////

		////////  DEPARTMENTS  ///////////
		UniversityDepartment ud1 = new UniversityDepartment();
		ud1.setDepartment_name("Bilgisayar Mühendisliği ");
			ProgramThroughputs pt1 = new ProgramThroughputs();	pt1.setThroughput_content("bilgisayar mühendisliği  program çıktısı 1");// pt1.setUniversityDepartment(ud1);
//			pt1.addTyycPcRelation(tyyc1.getId());	pt1.addTyycPcRelation(tyyc3.getId()); pt1.addTyycPcRelation(tyyc5.getId());
			ProgramThroughputs pt2 = new ProgramThroughputs();	pt2.setThroughput_content("bilgisayar mühendisliği  program çıktısı 2");// pt2.setUniversityDepartment(ud1);
//			pt2.addTyycPcRelation(tyyc2.getId());	pt2.addTyycPcRelation(tyyc4.getId()); pt2.addTyycPcRelation(tyyc6.getId());
		ud1.addProgramThroughput(pt1);
		ud1.addProgramThroughput(pt2);
		ud1.addTYYC(tyyc1);ud1.addTYYC(tyyc2);ud1.addTYYC(tyyc3);
		ud1.setUniversityMajorDepartment(umd1);

		UniversityDepartment ud2 = new UniversityDepartment();
		ud2.setDepartment_name("Yazılım Mühendisliği ");
			ProgramThroughputs pt3 = new ProgramThroughputs();	pt3.setThroughput_content("yazılım mühendisliği  program çıktısı 1");// pt3.setUniversityDepartment(ud1);
//			pt3.addTyycPcRelation(tyyc3.getId());	pt3.addTyycPcRelation(tyyc4.getId()); pt3.addTyycPcRelation(tyyc5.getId());
			ProgramThroughputs pt4 = new ProgramThroughputs();	pt4.setThroughput_content("yazılım mühendisliği  program çıktısı 2");// pt4.setUniversityDepartment(ud1);
//			pt4.addTyycPcRelation(tyyc1.getId());	pt4.addTyycPcRelation(tyyc2.getId()); pt4.addTyycPcRelation(tyyc6.getId());
		ud2.addProgramThroughput(pt3);
		ud2.addProgramThroughput(pt4);
		ud2.addTYYC(tyyc4);ud2.addTYYC(tyyc5);ud2.addTYYC(tyyc6);
		ud2.setUniversityMajorDepartment(umd2);
		////////    D-END     ////////

		//////////// Tyyc-pc-relation  ///////////////
		TyycPcRelation relation1 = new TyycPcRelation();
		relation1.setTyyc_id(3);
		relation1.setThroughput_id(2);
		TyycPcRelation relation2 = new TyycPcRelation();
		relation2.setTyyc_id(1);
		relation2.setThroughput_id(5);
		ud1.addTyycPcRelation(relation1);
		ud1.addTyycPcRelation(relation2);

		TyycPcRelation relation3 = new TyycPcRelation();
		relation3.setTyyc_id(4);
		relation3.setThroughput_id(25);
		TyycPcRelation relation4 = new TyycPcRelation();
		relation4.setTyyc_id(13);
		relation4.setThroughput_id(45);
		ud2.addTyycPcRelation(relation3);
		ud2.addTyycPcRelation(relation4);
		//////////// Tyyc-pc-relation  ///////////////

		////////  SEMESTERS  ///////////
		UniversitySemester us1 = new UniversitySemester();
			us1.setSemester_number(1);
			us1.setUniversityDepartment(ud1);
		UniversitySemester us2 = new UniversitySemester();
			us2.setSemester_number(2);
			us2.setUniversityDepartment(ud1);
		UniversitySemester us3 = new UniversitySemester();
			us3.setSemester_number(1);
			us3.setUniversityDepartment(ud2);
		UniversitySemester us4 = new UniversitySemester();
			us4.setSemester_number(2);
			us4.setUniversityDepartment(ud2);
		////////    S-END     ////////

		////////  LECTURE  ///////////
		UniversityLecture ul1 = new UniversityLecture();
			ul1.setLecture_name("İşletim Sistemleri");
			ul1.setLab_course_hour(3);
			ul1.setPractical_course_hour(2);
			ul1.setTheoretical_course_hour(1);
			ul1.setLecture_ECTS(6);
			ul1.setLecture_type(Lecture_type.ZORUNLU);
			ul1.setUniversitySemester(us1);
		UniversityLecture ul2 = new UniversityLecture();
			ul2.setLecture_name("Mikrodenetleyiciler");
			ul2.setLab_course_hour(1);
			ul2.setPractical_course_hour(2);
			ul2.setTheoretical_course_hour(3);
			ul2.setLecture_ECTS(5);
			ul2.setLecture_type(Lecture_type.SECMELİ);
			ul2.setUniversitySemester(us2);
		UniversityLecture ul3 = new UniversityLecture();
			ul3.setLecture_name("Bilgisayar Organizasyonu");
			ul3.setLab_course_hour(2);
			ul3.setPractical_course_hour(1);
			ul3.setTheoretical_course_hour(7);
			ul3.setLecture_ECTS(3);
			ul3.setLecture_type(Lecture_type.ZORUNLU);
			ul3.setUniversitySemester(us3);
		UniversityLecture ul4 = new UniversityLecture();
			ul4.setLecture_name("Bilgisayar Ağları");
			ul4.setLab_course_hour(5);
			ul4.setPractical_course_hour(4);
			ul4.setTheoretical_course_hour(3);
			ul4.setLecture_ECTS(8);
			ul4.setLecture_type(Lecture_type.ZORUNLU);
			ul4.setUniversitySemester(us4);
		////////    L-END     ////////

		////////  LECTURE-ECTS-WORKLOAD  ///////////
		Lecture_ECTS_workload workloadnumber = new Lecture_ECTS_workload();
		workloadnumber.setFinal_exam(1);
		workloadnumber.setHomeworks(3);
		workloadnumber.setLecture_specific_internship(1);
		workloadnumber.setLesson_duration(14);
		workloadnumber.setNon_exam_study_time(7);
		workloadnumber.setProjects(1);
		workloadnumber.setType(Lecture_ECTS_workload_type.NUMBER);

		Lecture_ECTS_workload workloadtime = new Lecture_ECTS_workload();
		workloadtime.setFinal_exam(1);
		workloadtime.setHomeworks(2);
		workloadtime.setLecture_specific_internship(40);
		workloadtime.setLesson_duration(1);
		workloadtime.setNon_exam_study_time(2);
		workloadtime.setProjects(20);
		workloadtime.setType(Lecture_ECTS_workload_type.TIME);
		////////  L-ECTS-W-END  ///////////

		////////  LESSON-EVALUATİON-SYSTEM  ///////////
		LessonEvaluationSystem eva1 = new LessonEvaluationSystem();
		eva1.setEvaluation_type(Evaluation_type.ARASINAV_SAYI);
		eva1.setExam(1);

		LessonEvaluationSystem eva2 = new LessonEvaluationSystem();
		eva2.setEvaluation_type(Evaluation_type.ARASINAV_KATKIPAYI);
		eva2.setExam(40);

		LessonEvaluationSystem eva3 = new LessonEvaluationSystem();
		eva3.setEvaluation_type(Evaluation_type.FINAL_SAYI);
		eva3.setExam(1);

		LessonEvaluationSystem eva4 = new LessonEvaluationSystem();
		eva4.setEvaluation_type(Evaluation_type.FINAL_KATKIPAYI);
		eva4.setExam(60);
		List<LessonEvaluationSystem> lessonEvaluationSystemList = new ArrayList<LessonEvaluationSystem>();
		lessonEvaluationSystemList.add(eva1);
		lessonEvaluationSystemList.add(eva2);
		lessonEvaluationSystemList.add(eva3);
		lessonEvaluationSystemList.add(eva4);
		////////  LES-EVA-S-END  ///////////

		////////  UNİVERSITY-LECTURE-CONTENT  ///////////
		UniversityLectureContent ulc1 = new UniversityLectureContent();
		Course_prerequisite cp1 = new Course_prerequisite();cp1.setPrerequisite_id(4567);
		ulc1.addCourse_prerequisite(cp1);
		ulc1.addLecture_info_by_weeks("ders içeriği 1","ders materyali 1");
		ulc1.addLecture_info_by_weeks("ders içeriği 2","ders materyali 2");
		ulc1.addLecture_ECTS_workload(workloadnumber);
		ulc1.addLecture_ECTS_workload(workloadtime);
		ulc1.setLessonEvaluationSystems(lessonEvaluationSystemList);
		ulc1.setCourse_purpose("İşletim Sistemleri dersi temel bi ders çok önemli");
		ulc1.addCourse_methods_and_techniques("Yüzyüze Soru-cevap Bilimsel çalışma ve tartışma");
		ulc1.addCourse_methods_and_techniques("Bilimsel çalışma ve tartışma Öğrencilerle Ortak Makale Hazırlama");
		ul1.setUniversityLectureContent(ulc1);

		UniversityLectureContent ulc2 = new UniversityLectureContent();
		Course_prerequisite cp2 = new Course_prerequisite();cp2.setPrerequisite_id(4156);
		ulc2.addCourse_prerequisite(cp2);
		ulc2.addLecture_info_by_weeks("ders içeriği 1","ders materyali 1");
		ulc2.addLecture_info_by_weeks("ders içeriği 2","ders materyali 2");
		ulc2.addLecture_ECTS_workload(workloadnumber);
		ulc2.addLecture_ECTS_workload(workloadtime);
		ulc2.setLessonEvaluationSystems(lessonEvaluationSystemList);
		ulc2.setCourse_purpose("Mikrodenetleyiciler almadan mühendis olamıyon");
		ulc2.addCourse_methods_and_techniques("Yüzyüze Soru-cevap Bilimsel çalışma ve tartışma");
		ulc2.addCourse_methods_and_techniques("Bilimsel çalışma,Makale Hazırlama");
		ul2.setUniversityLectureContent(ulc2);

		UniversityLectureContent ulc3 = new UniversityLectureContent();
		Course_prerequisite cp3 = new Course_prerequisite();cp3.setPrerequisite_id(4257);
		ulc3.addCourse_prerequisite(cp3);
		ulc1.addLecture_info_by_weeks("ders içeriği 1","ders materyali 1");
		ulc1.addLecture_info_by_weeks("ders içeriği 2","ders materyali 2");
		ulc3.addLecture_ECTS_workload(workloadnumber);
		ulc3.addLecture_ECTS_workload(workloadtime);
		ulc3.setLessonEvaluationSystems(lessonEvaluationSystemList);
		ulc3.setCourse_purpose("Bilgisayar Organizasyonu işlemcileri anlamak için çok önemli bir ders");
		ulc3.addCourse_methods_and_techniques("Yüzyüze Soru-cevap Bilimsel çalışma ve tartışma");
		ulc3.addCourse_methods_and_techniques(" Örnekler ile konunun pekiştirilmesi.");
		ul3.setUniversityLectureContent(ulc3);

		UniversityLectureContent ulc4 = new UniversityLectureContent();
		Course_prerequisite cp4 = new Course_prerequisite();cp4.setPrerequisite_id(427);
		ulc4.addCourse_prerequisite(cp4);
		ulc4.addLecture_ECTS_workload(workloadnumber);
		ulc4.addLecture_ECTS_workload(workloadtime);
		ulc4.setLessonEvaluationSystems(lessonEvaluationSystemList);
		ulc4.setCourse_purpose("Bilgisayar Ağları ağ mimarisini anlamak için önemli");
		ulc4.addCourse_methods_and_techniques("Anlatım, Soru-Cevap, Tartışma, Örnek Olay, Ödev");
		ulc4.addCourse_methods_and_techniques("Çift yönlü iletişim ile konuların değerlendirilmesi");
		ul4.setUniversityLectureContent(ulc4);
		////////    ULC-END     ////////

		////////  LECTURE LEARNİNG OUTCOMES  ///////////
		LectureLearningOutcomes outcome1 = new LectureLearningOutcomes();
		outcome1.setContribution_degree(ContributionDegree.COK_IYI);
		outcome1.setLearning_outcome("Bu ders bir işletim sisteminin donanımı nasıl em verimli şekilde kullanmak için uğraştığını anlatır. ");
		LectureLearningOutcomes outcome2 = new LectureLearningOutcomes();
		outcome2.setContribution_degree(ContributionDegree.IYI);
		outcome2.setLearning_outcome("Bu ders bir mikrodenetleyici ile nasıl harika işler yapılabileceğini anlatır.");
		LectureLearningOutcomes outcome3 = new LectureLearningOutcomes();
		outcome3.setContribution_degree(ContributionDegree.COK_IYI);
		outcome3.setLearning_outcome("İşlemcinin içinde ne var sorusunun net cevabı bu derste.");
		LectureLearningOutcomes outcome4 = new LectureLearningOutcomes();
		outcome4.setContribution_degree(ContributionDegree.ORTA);
		outcome4.setLearning_outcome("İnternet nedir sorusuna cevap niteliğinde");

		ulc1.addLectureLearningOutcomes(outcome1);
		ulc1.addLectureLearningOutcomes(outcome2);
		ulc2.addLectureLearningOutcomes(outcome3);
		ulc2.addLectureLearningOutcomes(outcome4);
//		outcome1.setUniversityLectureContent(ulc1);
//		outcome2.setUniversityLectureContent(ulc2);
//		outcome3.setUniversityLectureContent(ulc3);
//		outcome4.setUniversityLectureContent(ulc4);
		////////  LEC-LEA-OUTCOME-END  ///////////

		////////    LLO-PT-RELATION     ////////
		LLO_PT_Relation lloPtRelation1 = new LLO_PT_Relation();
		lloPtRelation1.setLearning_outcome_id(6);
		lloPtRelation1.setThroughput_id(2);
		ulc1.addLLO_PT_Relation(lloPtRelation1);

		LLO_PT_Relation lloPtRelation2 = new LLO_PT_Relation();
		lloPtRelation2.setLearning_outcome_id(1);
		lloPtRelation2.setThroughput_id(2);
		ulc1.addLLO_PT_Relation(lloPtRelation2);

		LLO_PT_Relation lloPtRelation3 = new LLO_PT_Relation();
		lloPtRelation3.setLearning_outcome_id(23);
		lloPtRelation3.setThroughput_id(12);
		ulc2.addLLO_PT_Relation(lloPtRelation3);

		LLO_PT_Relation lloPtRelation4 = new LLO_PT_Relation();
		lloPtRelation4.setLearning_outcome_id(9);
		lloPtRelation4.setThroughput_id(4);
		ulc2.addLLO_PT_Relation(lloPtRelation4);
		//////// LLO-PT-RELATION-EMD ///////////

		////////  PAGE  ///////////
		Pages page1 = new Pages();
		page1.setName("Temel Bilgiler");
		PageContent pageContent1 = new PageContent();
		pageContent1.setContent("Bologna Süreci, 2010 yılına kadar Avrupa Yükseköğretim Alanı yaratmayı hedefleyen bir reform sürecidir. Pek çok uluslararası kuruluşun işbirliği ile 47 üye ülke (Karadağ'ın bağımsızlığını ilan etmesiyle üye ülke sayısı 45 ten 46 ya, son olarak Kazakistan'ın da sürece dahil olmasıyla 47'ye yükselmiştir) tarafından oluşturulan ve sürdürülen, alışılmışın dışında bir süreçtir. Sürece üyelik hükümetler/devletler arası herhangi bir anlaşmaya dayanmamaktadır. Bologna Süreci kapsamında yayımlanan bildirilerin yasal bir bağlayıcılığı bulunmamaktadır. Süreç tamamen her ülkenin özgür iradeleri ile katıldıkları bir oluşumdur ve ülkeler Bologna Süreci'nin öngördüğü hedefleri kabul edip etmeme hakkına sahiptirler.");
		pageContent1.setName("Bologna Süreci Nedir?");
		page1.addPageContent(pageContent1);
		////////  PAGE END  //////////

		////////  PERSİST  ///////////
		entityManager.getTransaction().begin();
		entityManager.persist(pageContent1);
		entityManager.persist(page1);
		entityManager.persist(university1);
		entityManager.persist(umd1);
		entityManager.persist(umd2);
		entityManager.persist(ud1);
		entityManager.persist(ud2);
			entityManager.persist(pt1);
			entityManager.persist(pt2);
			entityManager.persist(pt3);
			entityManager.persist(pt4);
			entityManager.persist(tyyc1);
			entityManager.persist(tyyc2);
			entityManager.persist(tyyc3);
			entityManager.persist(tyyc4);
			entityManager.persist(tyyc5);
			entityManager.persist(tyyc6);
			entityManager.persist(relation1);
			entityManager.persist(relation2);
			entityManager.persist(relation3);
			entityManager.persist(relation4);
		entityManager.persist(us1);
		entityManager.persist(us2);
		entityManager.persist(us3);
		entityManager.persist(us4);
		entityManager.persist(ul1);
		entityManager.persist(ul2);
		entityManager.persist(ul3);
		entityManager.persist(ul4);
		entityManager.persist(ulc1);
		entityManager.persist(ulc2);
		entityManager.persist(ulc3);
		entityManager.persist(ulc4);
			entityManager.persist(outcome1);
			entityManager.persist(outcome2);
			entityManager.persist(outcome3);
			entityManager.persist(outcome4);
			entityManager.persist(lloPtRelation1);
			entityManager.persist(lloPtRelation2);
			entityManager.persist(lloPtRelation3);
			entityManager.persist(lloPtRelation4);
		entityManager.getTransaction().commit();
		////////    PERSİST-END     ////////
	}
}





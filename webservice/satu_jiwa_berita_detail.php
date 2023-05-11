<?php
$list_berita_detail = [
    ["id" => 1, "news_title" => "Ayo Berkontribusi di Gerakan #SatuJiwa #SatuUBAYA #UBAYAforIndonesia", "img_url" => "https://satujiwa.ubaya.ac.id/home/index.php/uploads/news/4.1.jpg", 
        "tanggal_rilis" => "07-05-2023",
        "sinopsis" => "Gerakan #SatuJiwa #SatuUBAYA #UBAYAforIndonesia untuk membantu keluarga UBAYA terdampak Covid-19 melalui no. rekening BCA 088 643 2393 Cabang Darmo Surabaya a.n. Yayasan Universitas Surabaya",
        "detail" => "UBAYAtizen, saatnya kita bersatu dan berkontribusi bersama dalam aksi nyata caring community gerakan #SatuJiwa #SatuUBAYA #UBAYAforIndonesia untuk membantu keluarga UBAYA terdampak Covid-19 melalui: No. Rekening BCA 088 643 2393 Cabang Darmo Surabaya a.n. Yayasan Universitas Surabaya dan melalui platform digital saling bantu keluarga UBAYA satujiwa.ubaya.ac.id #SatuJiwa #Satu UBAYA merupakan bagian gerakan #UBAYAfor Indonesia, wujud nyata UBAYA berkontribusi untuk Indonesia maju. Hingga Jumat, 17 Juli 2020, telah terkumpul kontribusi Rp.126.846.010,56,- dari 269 kontribusi terverifikasi. Terima kasih atas kontribusi Bapak/Ibu/Sdr semua. Kiranya kebaikan Bapak/Ibu/Sdr dibalaskan Tuhan yang Kuasa."],
    ["id" => 2, "news_title" => "PC Baru Demi Masa Depan Cerah", "img_url" => "https://w0.peakpx.com/wallpaper/106/535/HD-wallpaper-pc-gamer.jpg", 
        "tanggal_rilis" => "08-05-2023",
        "sinopsis" => "Agar sukses di bidang IT, teman kita memerlukan PC baru untuk mendukung proses pembelajarannya, ayo kita dukung dengan menyalurkan bantuan melalui no. rekening BCA 012 345 6789 a.n. Vincent", 
        "detail" => "Agar sukses di bidang IT, teman kita memerlukan PC baru untuk mendukung proses pembelajarannya, ayo kita dukung dengan menyalurkan bantuan melalui no. rekening BCA 012 345 6789 a.n. Vincent"],
    ["id" => 3, "news_title" => "Peningkatan Lifestyle agar Hidup Bahagia", "img_url" => "https://wallpaperaccess.com/full/5089971.jpg", 
        "tanggal_rilis" => "09-05-2023",
        "sinopsis" => "Untuk bertahan di dunia yang penuh tekanan, teman kita memerlukan peningkatan gaya hidup untuk menyokong kesehatan mentalnya, ayo kita salurkan bantuan melalui no. rekening BCA 123 456 7890 a.n. Dastyn", 
        "detail" => "Untuk bertahan di dunia yang penuh tantangan dan tekanan, salah seorang teman kita memerlukan bantuan untuk menyokong kesehatan mentalnya dengan cara meningkatkan gaya hidupnya saat ini, ayo kita salurkan bantuan melalui no. rekening BCA 123 456 7890 a.n. Dastyn"]
    ];

if (isset($_GET['id']) && is_numeric($_GET['id'])){
    $selectedId = $_GET['id'];
    $berita_detail = null;
    for($i=0; $i < count($list_berita_detail); $i++)
    {
        if($list_berita_detail[$i]['id'] == $selectedId){
            $berita_detail = $list_berita_detail[$i];
            break;
        }
    }
    echo json_encode($berita_detail);
}
else{
    echo json_encode($list_berita_detail);
}

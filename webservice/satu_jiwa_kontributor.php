<?php
$list_kontribusi = [
    ["id" => 1, "nama" => "Jeniffer", "jumlah" => 1500000, "tanggal" => "11-05-2023", "id_donation" => 1],
    ["id" => 2, "nama" => "Jack", "jumlah" => 1500000, "tanggal" => "11-05-2023", "id_donation" => 1],
    ["id" => 3, "nama" => "Johnson", "jumlah" => 1500000, "tanggal" => "11-05-2023", "id_donation" => 1],
    ["id" => 4, "nama" => "Julian", "jumlah" => 1500000, "tanggal" => "11-05-2023", "id_donation" => 1],
    ["id" => 5, "nama" => "Jina", "jumlah" => 1500000, "tanggal" => "11-05-2023", "id_donation" => 1],
    ["id" => 6, "nama" => "Jeniffer", "jumlah" => 1000000, "tanggal" => "11-05-2023", "id_donation" => 1],
    ["id" => 7, "nama" => "Jack", "jumlah" => 50000, "tanggal" => "11-05-2023", "id_donation" => 2],
    ["id" => 8, "nama" => "Johnson", "jumlah" => 100000, "tanggal" => "11-05-2023", "id_donation" => 2],
    ["id" => 9, "nama" => "Julian", "jumlah" => 25000, "tanggal" => "11-05-2023", "id_donation" => 2],
    ["id" => 10, "nama" => "Jina", "jumlah" => 50000, "tanggal" => "11-05-2023", "id_donation" => 2],
    ["id" => 11, "nama" => "Jeniffer", "jumlah" => 75000, "tanggal" => "11-05-2023", "id_donation" => 2],
    ["id" => 12, "nama" => "Jack", "jumlah" => 100000, "tanggal" => "11-05-2023", "id_donation" => 3],
    ["id" => 13, "nama" => "Johnson", "jumlah" => 1000000, "tanggal" => "11-05-2023", "id_donation" => 4],
    ["id" => 14, "nama" => "Julian", "jumlah" => 1000000, "tanggal" => "11-05-2023", "id_donation" => 4],
    ["id" => 15, "nama" => "Jina", "jumlah" => 1000000, "tanggal" => "11-05-2023", "id_donation" => 4],
    ["id" => 16, "nama" => "Jeniffer", "jumlah" => 1000000, "tanggal" => "11-05-2023", "id_donation" => 4],
    ["id" => 17, "nama" => "Jack", "jumlah" => 500000, "tanggal" => "11-05-2023", "id_donation" => 5],
    ["id" => 18, "nama" => "Johnson", "jumlah" => 500000, "tanggal" => "11-05-2023", "id_donation" => 5],
    ["id" => 19, "nama" => "Julian", "jumlah" => 485000, "tanggal" => "11-05-2023", "id_donation" => 5],
    
    ];

if (isset($_GET['id']) && is_numeric($_GET['id'])){
    $selectedId = $_GET['id'];
    $list_contributor = [];
    for($i=0; $i < count($list_kontribusi); $i++)
    {
        if($list_kontribusi[$i]['id_donation'] == $selectedId){
            array_push($list_contributor, $list_kontribusi[$i]);
        }
    }
    echo json_encode($list_contributor);
}

function storeValues(){
    var gallery_name=document.getElementById("gn").value;

document.cookie = "gallery_name="+gallery_name;
   
 return true;

}

function store_values(id){
    document.cookie = "gallery_name="+id;
}
function storeValue(){
    var gallery_name=document.getElementById("gn").value;

document.cookie = "gallery_name="+gallery_name;
   
 return true;

}

function store_values(id){

    document.cookie = "gallery_name="+id;
    var preview='/galleryPreview';
    var host=window.location.href+preview;
    
    location.href=host;
}
function deleteCookies(){
    document.cookie = "gallery_name=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/DynamicPictureGallery;";
  }
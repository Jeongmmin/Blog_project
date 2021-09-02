<template>
    <div class="container">
        <div class="row">
            <div class="col-sm">
                <!-- <h4>FOOTER</h4>
                <p>Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida diam non fringilla.</p>
                <p>Powered by <a href="#">w3.css</a></p> -->
                <div style="width:80%;" id="category2">
                <h6><b>category</b></h6>
                <ul>
                    <a href="#"><li>일상</li></a>
                    <a href="#"><li>체험단</li></a>
                    <a href="#"><li>음악</li></a>
                    <a href="#"><li>여행</li></a>
                        <a href="#"><li>~2021</li></a>
                        <a href="#"><li>~2020</li></a>
                        <a href="#"><li>~2019</li></a>
                </ul>
                </div>
            </div>
            <div class="col-sm">
                <h6><b>music list</b></h6>
                <div class="card" id="card2">
                <div class="row no-gutters">
                    <div class="col-sm-4">
                    <img src="https://musicmeta-phinf.pstatic.net/album/006/153/6153066.jpg?type=r480Fll&v=20210706175913" id="img2">
                    </div>
                    <div class="col-sm-8">
                    <div class="card-body">
                        <h5 class="card-title">Weekend</h5>
                        <p class="card-text"><small class="text-muted">태연 (TAEYEON)</small></p>
                    </div>
                    </div>
                </div>
                </div>
                <div class="card" id="card2">
                <div class="row no-gutters">
                    <div class="col-sm-4">
                    <img src="https://musicmeta-phinf.pstatic.net/album/006/247/6247807.jpg?type=r480Fll&v=20210730102608" id="img2">
                    </div>
                    <div class="col-sm-8">
                    <div class="card-body">
                        <h5 class="card-title">낙하 (with 아이유)</h5>
                        <p class="card-text"><small class="text-muted">AKMU(악뮤)</small></p>
                    </div>
                    </div>
                </div>
                </div>
            </div>
            <div class="col-sm">
                <h6><b>POPULAR TAGS</b></h6>
                <p>

                    <span class="badge badge-dark">#Travel</span> <span class="badge badge-dark">#여행</span> <span class="badge badge-dark">제주도여행</span><br>
                    <span class="badge badge-dark">#음악</span> <span class="badge badge-dark">#맛집</span> <span class="badge badge-dark">#인기차트</span><br>
                    <span class="badge badge-dark">#앨범</span> <span class="badge badge-dark">#music</span> <span class="badge badge-dark">#맛집탐방</span><br>
                    <span class="badge badge-dark">#전자기기</span> <span class="badge badge-dark">#패션</span> <span class="badge badge-dark">#ootd</span><br>
                    <span class="badge badge-dark">#sports</span> <span class="badge badge-dark">#games</span>
                </p>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    
}
</script>

<style scoped>
#img2 {
    width: 60px;
    height: 60px;
    margin-top:5px ;
}
li {
    list-style: none;
}
#card2{
    background: none;
    border: 0;
}
#category2 {
    font-size: 15px;
    text-align: center;
    margin: auto;
}
a {
    color: gray;
}
h6{
    margin: 10px;
}
.card-body {
    margin-top: -20px;
}
.container {
    border: 1px solid rgb(226, 224, 224);
    width: 80%;
}
</style>
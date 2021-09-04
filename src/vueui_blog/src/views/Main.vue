<template>
    <div style="width:80%;margin:auto">
        <main class="container" id="maincontainer">
        <!-- <router-link to="/">list</router-link> | 
        <router-link to="/insert">write</router-link> |
        <router-link to="/detail">detail</router-link> -->
        <!-- <router-view></router-view> -->
        <!-- <nav class="navbar navbar-expand-lg navbar-light ">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ">
            <a class="nav-link" href="#">프롤로그 <span class="sr-only">(current)</span></a> 
            </li>
        </ul>
        <ul class="navbar-nav mr-right">
            <li class="nav-item ">
            <a class="nav-link" ><button type="button" data-toggle="button" v-on:click="moveList">목록열기</button>목록열기 <span class="sr-only">(current)</span></a> 
            </li>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </ul>
        </div>
        </nav> -->
    <!-- <div>
        <router-view></router-view>
    </div> -->
    <div class="row row-cols-1 row-cols-md-2" id="cardgrooup">
        <div class="col mb-4">
            <div class="card">
            <img src="../assets/01.jpg" class="card-img-top" >
            <div class="card-body">
                <h5 class="card-title">첫번째 포스팅</h5>
                <p class="card-text">컨셉별로 떠나는 제주도여행</p>
            </div>
            </div>
        </div>
        <div class="col mb-4">
            <div class="card">
            <img src="../assets/03.jpg" class="card-img-top" >
            <div class="card-body">
                <h5 class="card-title">두번째 포스팅</h5>
                <p class="card-text">#2030 혼자 떠나는 여행 : 제주 서쪽해안 코스</p>
            </div>
            </div>
        </div>
        <div class="col mb-4">
            <div class="card">
            <img src="../assets/02.jpg" class="card-img-top" >
            <div class="card-body">
                <h5 class="card-title">세번째 포스팅</h5>
                <p class="card-text">#일몰 명소로 이동해 풍차와 노을을 보며 하루를 마무리</p>
            </div>
            </div>
        </div>
        <div class="col mb-4">
            <div class="card">
            <img src="../assets/04.jpg" class="card-img-top" >
            <div class="card-body">
                <h5 class="card-title">네번째 포스팅</h5>
                <p class="card-text">#부모님과 여행 : 제주 동부권 코스</p>
            </div>
            </div>
        </div>
    </div>
    </main>
    <footer>
        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center" id="page">
                <li class="page-item">
                <a class="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
                </li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">4</a></li>
                <li class="page-item"><a class="page-link" href="#">5</a></li>
                <li class="page-item"><a class="page-link" href="#">6</a></li>
                <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
                </li>
            </ul>
        </nav>
    </footer>
    </div>
    
</template>

<script>
export default {
    data() {
        return {
            items: []
        }
    },
    methods: {
        moveDetail(seq) {
            // push() - <router-link> 태그와 동일한 기능을 하는 함수
            // 화면 이동 시 파라미터값을 전송하려면 params 객체를 사용하여 데이터를 전송
            this.$router.push({ name: 'Detail', query: { seq: seq }});
        },
    
        moveInsert() {
            this.$router.push({name: 'Insert'});
        }
    },
    mounted() {
        let obj = this;

        obj.$axios.get("http://localhost:9000/blogList")
        .then(function(res) {
            console.log("axios로 비동기 통신 성공");
            obj.items = res.data;
        })
        .catch(function(err) {
            console.log("axios 비동기 통신 오류");
            console.log(err);
        });
    }
}
</script>


<style scoped>
    .card-header {
        background-color: none;
    }
    #cardgrooup {
        margin-top: 20px;
        margin-bottom: 20px;
    }
    #maincontainer {
        margin-top: 20px;
        border: 2px solid rgb(226, 224, 224);
    }

    footer {
        border:  2px solid rgb(226, 224, 224);
        margin-top: 10px;
        margin-bottom: 10px;
    }
    #page {
        margin-top: 10px;
        margin-bottom: 10px;
    }
    .page-link {
        color: gray;
        border: 0px;
        margin-right: 10px;
    }
    #buttonlist {
        color: rgb(92, 92, 92);
        text-decoration-color: gray;
    }
</style>
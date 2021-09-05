<template>
    <!-- <header class="container">
        <div class="jumbotron">
            <h1>Vue를 사용한 게시판 만들기</h1>
        </div>
    </header> -->
    <div style="width:80%;margin:auto">
        <nav class="navbar navbar-expand-lg navbar-light ">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="nvbar-nav mx-auto">

                </ul>
                <ul class="navbar-nav mr-right">
                    <li class="nav-item  active">
                    <a class="nav-link" href="#">내블로그<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                    <a class="nav-link" href="#">이웃블로그</a>
                    </li>
                    <li class="nav-item ">
                    <a class="nav-link" href="#">블로그홈<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                    <a class="nav-link" href="#">아이디</a>
                    </li>
                </ul>
            </div>
        </nav>
        <img src="https://images.pexels.com/photos/736049/pexels-photo-736049.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260" class="img" alt="...">
        <nav class="navbar navbar-expand-lg navbar-light ">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ">
            <a class="nav-link" href="#">프롤로그 <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
            <a class="nav-link" href="#">블로그</a>
            </li>
            <li class="nav-item ">
            <a class="nav-link" href="#">맛집탐방 <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
            <a class="nav-link" href="#">일상</a>
            </li>
            <li class="nav-item">
            <a class="nav-link" href="#">여행</a>
            </li>
            <li class="nav-item">
            <a class="nav-link" href="#">음악</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input
            class="form-control mr-sm-2"
            type="search"
            placeholder="이 블로그에서 검색"
            aria-label="Search"
            />
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">
            N
            </button>
        </form>
        </div>
    </nav>
    </div>
    
</template>

<script>
    export default {
    // data() {
    //     return {
    //         items: []
    //     }
    // },
    // methods: {
    //     moveDetail(seq) {
    //         // push() - <router-link> 태그와 동일한 기능을 하는 함수
    //         // 화면 이동 시 파라미터값을 전송하려면 params 객체를 사용하여 데이터를 전송
    //         this.$router.push({ name: 'Detail', query: { seq: seq }});
    //     },
    
    //     moveInsert() {
    //         this.$router.push({name: 'Insert'});
    //     }
    // },
    // mounted() {
    //     let obj = this;

    //     obj.$axios.get("http://localhost:9000/blogList")
    //     .then(function(res) {
    //         console.log("axios로 비동기 통신 성공");
    //         obj.items = res.data;
    //     })
    //     .catch(function(err) {
    //         console.log("axios 비동기 통신 오류");
    //         console.log(err);
    //     });
    // }
}
</script>

<style scoped>
    #side {
    margin-left: 10px;
    }
    .mb-3 {
    margin-left: 0px;
    }
    #g {
    color: gray;
    }
    i {
    margin-right: 10px;
    color: black;
    }
    
    img {
        height:200px;
        width: 100%;
    }
    #buttonlist {
        color: rgb(92, 92, 92);
        text-decoration-color: gray;
    }
    h2 {
        text-decoration-color: none;
    }
</style>

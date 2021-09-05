<template>
    <div style="width: 80%; margin: auto">
        <main class="container" id="maincontainer">
            <div class="accordion" id="accordionExample">
                <div class="card">
                    <div class="card-header" id="headingOne">
                        <h2 class="mb-0">
                            <button
                                class="btn btn-link btn-block text-right"
                                id="buttonlist"
                                type="button"
                                data-toggle="collapse"
                                data-target="#collapseOne"
                                aria-expanded="false"
                                aria-controls="collapseOne"
                            >
                                목록열기
                            </button>
                        </h2>
                    </div>
                    <div
                        id="collapseOne"
                        class="collapse"
                        aria-labelledby="headingOne"
                        data-parent="#accordionExample"
                    >
                        <div class="card-body">
                            <div class="container">
                                <div class="col-md-12 mx-auto">
                                    <table class="table table-sm">
                                        <colgroup>
                                            <col width="5%" />
                                            <col width="*" />
                                            <col width="20%" />
                                            <col width="10%" />
                                        </colgroup>
                                        <thead class="thead">
                                            <tr>
                                                <th>#</th>
                                                <th>제목</th>
                                                <th>작성일</th>
                                                <th>조회수</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr
                                                v-for="item in items"
                                                v-bind:key="item.seq"
                                            >
                                                <td>{{ item.seq }}</td>
                                                <td
                                                    class="text-center"
                                                    v-on:click="
                                                        moveDetail(item.seq)
                                                    "
                                                >
                                                    {{ item.title }}
                                                </td>
                                                <td>{{ item.createdDate }}</td>
                                                <td>{{ item.hitCnt }}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row row-cols-1 row-cols-md-2" id="cardgrooup">
                <div class="col mb-4">
                    <div class="card">
                        <img src="../assets/01.jpg" class="card-img-top" />
                        <div class="card-body">
                            <h5 class="card-title">첫번째 포스팅</h5>
                            <p class="card-text">컨셉별로 떠나는 제주도여행</p>
                        </div>
                    </div>
                </div>
                <div class="col mb-4">
                    <div class="card">
                        <img src="../assets/03.jpg" class="card-img-top" />
                        <div class="card-body">
                            <h5 class="card-title">두번째 포스팅</h5>
                            <p class="card-text">
                                #2030 혼자 떠나는 여행 : 제주 서쪽해안 코스
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col mb-4">
                    <div class="card">
                        <img src="../assets/02.jpg" class="card-img-top" />
                        <div class="card-body">
                            <h5 class="card-title">세번째 포스팅</h5>
                            <p class="card-text">
                                #일몰 명소로 이동해 풍차와 노을을 보며 하루를
                                마무리
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col mb-4">
                    <div class="card">
                        <img src="../assets/04.jpg" class="card-img-top" />
                        <div class="card-body">
                            <h5 class="card-title">네번째 포스팅</h5>
                            <p class="card-text">
                                #부모님과 여행 : 제주 동부권 코스
                            </p>
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
                    <li class="page-item">
                        <a class="page-link" href="#">1</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">2</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">3</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">4</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">5</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">6</a>
                    </li>
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
            items: [],
        };
    },
    methods: {
        moveDetail(seq) {
            // push() - <router-link> 태그와 동일한 기능을 하는 함수
            // 화면 이동 시 파라미터값을 전송하려면 params 객체를 사용하여 데이터를 전송
            this.$router.push({ name: "Detail", query: { seq: seq } });
        },

        moveInsert() {
            this.$router.push({ name: "Insert" });
        },
    },
    mounted() {
        let obj = this;

        obj.$axios
            .get("http://localhost:9000/blogList")
            .then(function (res) {
                console.log("axios로 비동기 통신 성공");
                obj.items = res.data;
            })
            .catch(function (err) {
                console.log("axios 비동기 통신 오류");
                console.log(err);
            });
    },
};
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
}
footer {
    margin-top: 10px;
    margin-bottom: 50px;
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

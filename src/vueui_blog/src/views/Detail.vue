<template>
<div>
    <div class="container" id="tablediv">
        <table class="table-borderless">
            <thead>
                <tr id="thtr">
                    <th scope="col" colspan="2"><h3>{{title}}</h3></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td col class="text-left"><h6>{{creatorId}}</h6></td>
                    <td col><h6>{{createdDate}}</h6></td>
                </tr>
                <tr>
                    <td colspan="2">{{contents}}</td>
                </tr>
            </tbody>
        </table>
    </div>
    <div class="row">
        <div class="container">
            <div class="row">
                    <div class="col-md-12 clear-fix">
                        <button type = "button" class = "btn btn btn-sm float-left" v-on:click = "moveList" id="btnlist"> 목록 </button>
                        <button type = "button" class = "btn btn btn-sm float-right mr-2" v-on:click = "boardDelete" id="btndel"> 삭제 </button>
                        <button type = "button" class = "btn btn btn-sm float-right" v-on:click = "boardUpdate" id="btnmodi"> 수정 </button>
                    </div>
            </div>
        </div>
    </div>
</div>
    
</template>

<script>
export default {
    data() {
        return {
            seq:0,
            title:'',
            createdDate:'',
            hitCnt:0,
            creatorId:'',
            contents:''
        }
    },
    methods: {
        moveList() {
            this.$router.push({ name:'Main'});
        },
        boardUpdate() {
            let obj =this;
            this.$axios.put('http://localhost:9000/blogDetail', {
                seq: this.seq,
                title: this.title,
                contents: this.contents,
                updateId: this.creatorId
            })
            .then(function() {
                console.log('비동기 통신 성공');
                obj.$router.push({name:'List'});
            })
            .catch(function(err) {
                console.log("axios 비동기 통신 오류");
                console.log(err);
            });
        },
        boardDelete() {
            let obj = this;
            this.$axios.delete('http://localhost:9000/deleteBlogBoard', {
                params: {
                    seq: this.seq
                }
            })
            .then(function() {
                console.log('비동기 통신 성공');
                obj.$router.push({name:'List'});
            })
            .catch(function(err) {
                console.log("axios 비동기 통신 오류");
                console.log(err);
            });
        }
    },
    mounted() {
        let obj = this;

        // this.boardIdx = this.$route.params.boardIdx;
        obj.seq = obj.$route.query.seq;
        // if (obj.$route.params.boardIdx == undefined || obj.$route.params.seq == null || obj.$route.params.seq == 0) {
        //     obj.seq = 16;
        // }
        // else {
        //     obj.seq = obj.$route.params.seq;
        // }
        

        obj.$axios.get('http://localhost:9000/blogDetail', {
            params: {
                seq: obj.seq
            }
        })
        .then(function(res) {
            console.log('비동기통신 성공');

            obj.seq = res.data.seq;
            obj.createdDate = res.data.createdDate;
            obj.creatorId = res.data.creatorId;
            obj.title = res.data.title;
            obj.hitCnt = res.data.hitCnt;
            obj.contents = res.data.contents;

        })
        .catch(function(err) {
            console.log('비동기통신 실패');
            console.log(err);
        });  
    }
}
</script>

<style scoped>
#tablediv {
    background-color: white;
    margin-top: 50px;
}
.container {
    width: 80%;
}
.btn {
    border-radius: 50px;
    background-color: rgb(163, 161, 165);
    color: white;
}
/* #btnlist {
    background-color: rgb(163, 161, 165);
    color: white;
} */
#btnmodi {
    margin-right: 10px;
}
/* #btndel {
    background-color: rgb(163, 161, 165);
    color: white;
} */
th {
    padding: 30px;
}
td {
    border-top: none;
    padding: 10px;
}
thead {
    border-bottom: 1px solid lightgray;
}
/* #thtr {
    border: none;
} */
table {
    text-align: center;
    width: 100%;
}
</style>


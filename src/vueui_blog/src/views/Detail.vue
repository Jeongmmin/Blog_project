<template>
    <div class="row">
        <div class="container text-left">
            <div class="form-group">
                <label for="title">제목 : </label>
                <input type="text" class="form-control" id="title" name="title" v-model="title">
            </div>
            <div class="form-group">
                <label for="createdDate">등록일 : </label>
                <input type="text" class="form-control" id="tcreatedDatetle" name="createdDate" v-model="createdDate">
            </div>
            <div class="form-group">
                <label for="hitCnt">조회수 : </label>
                <input type="text" class="form-control" id="hitCnt" name="hitCnt" v-model="hitCnt">
            </div>
            <div class="form-group">
                <label for="creatorId">사용자 ID : </label>
                <input type="text" class="form-control" id="creatorId" name="creatorId" v-model="creatorId">
            </div>
            <div class="form-group">
                <label for="contents">글 내용 : </label>
                <textarea class="form-control" id="contents" name="contents" cols="30" rows="10" v-model="contents"></textarea>
            </div>
            <div class="row">
                    <div class="col-md-12 clear-fix">
                        <button type = "button" class = "btn btn-outline-dark float-left" v-on:click = "moveList"> 목록 </button>
                        <button type = "button" class = "btn btn-outline-success float-right" v-on:click = "boardUpdate"> 수정 </button>
                        <button type = "button" class = "btn btn-outline-danger float-right mr-2" v-on:click = "boardDelete"> 삭제 </button>
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
            this.$router.push({ name:'List'});
        },
        boardUpdate() {
            let obj =this;
            this.$axios.put('http://localhost:9000/vue/axiosBoardUpdate', {
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
            this.$axios.delete('http://localhost:9000/vue/axiosBoardDelete', {
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

        //this.boardIdx = this.$route.params.boardIdx;
        if (obj.$route.params.boardIdx == undefined || obj.$route.params.seq == null || obj.$route.params.seq == 0) {
            obj.seq = 16;
        }
        else {
            obj.seq = obj.$route.params.seq;
        }
        

        obj.$axios.get('http://localhost:9000/vue/axiosBoardDetail', {
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

<style>

</style>

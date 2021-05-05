<template>
  <div class="wrapper">
    <parallax
      class="section page-header header-filter"
      :style="headerStyle"
    ></parallax>
    <div class="main main-raised">
      <div class="section profile-content">
        <div class="container">
          <div class="md-layout">
            <div class="md-layout-item md-size-50 mx-auto">
              <div style="text-align:center"></div>
            </div>
            <!-- </div> -->
            <br />
            <div style="width:90%;text-align:center;margin-top:20px">
              <h2>{{ board.title }}</h2>
            </div>
            <div id="detailContents">
              {{ board.contents }}
            </div>
            <p style="width:90%;">
              <v-btn style="width:10%; margin-left:79%;margin-top:10px;margin-right:20px">수정</v-btn>
              <v-btn style="width:10%; margin-left:90%;margin-top:-60px">삭제</v-btn>
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  data() {
    return {
      board: [],
    };
  },

  components: {},
  bodyClass: 'profile-page',

  props: {
    header: {
      type: String,
      default: require('@/assets/img/city-profile.jpg'),
    },
    img: {
      type: String,
      default: require('@/assets/img/faces/christian.jpg'),
    },
  },
  created() {
    this.readBoard();
  },
  methods: {
    async readBoard() {
      try {
        const res = await axios.get(`${SERVER_URL}/board/read`, {
          params: { type: 'id', word: this.$route.params.id },
        });
        this.board = res.data[0];
        console.log(res.data[0].title + '?');
        // this.hashKey = res.data.vote.hashKey;
        // const idx = res.data.vote.contractAddress * 1;
        // await this.getData(idx);

        // this.n = idx;
      } catch (err) {
        console.log(err);
      }
    },
  },
  computed: {
    headerStyle() {
      return {
        backgroundImage: `url(${this.header})`,
      };
    },
  },
};
</script>

<style lang="scss" scoped>
.section {
  padding: 0;
}

.profile-tabs::v-deep {
  .md-card-tabs .md-list {
    justify-content: center;
  }

  [class*='tab-pane-'] {
    margin-top: 3.213rem;
    padding-bottom: 50px;

    img {
      margin-bottom: 2.142rem;
    }
  }
}
#detailContents {
  border: 1px solid grey;
  width:90%;
  height:400px;
}
</style>

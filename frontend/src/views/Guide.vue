<template>
  <div class="wrapper">
    <parallax
      class="section page-header header-filter"
      :style="headerStyle"
    ></parallax>
    <div class="main main-raised">
      <h2 class="text-center">
        텃밭 종류별 키우기 좋은 작물
      </h2>
      <div class="md-layout">
        <div class="md-layout-item text-center">
            <md-button @click="getCropsList(place[0])" class="md-simple md-success md-lg">
            베란다 텃밭
            </md-button>
        </div>
        <div class="md-layout-item text-center">
            <md-button @click="getCropsList(place[1])" class="md-simple md-success md-lg">
            옥상정원
            </md-button>
        </div>
        <div class="md-layout-item text-center">
            <md-button @click="getCropsList(place[2])" class="md-simple md-success md-lg">
            주말 농장
            </md-button>
        </div>
      </div>
      <div class="section profile-content">
        <div class="container">
          <div class="md-layout">
            <div class="md-layout-item md-size-25 md-xsmall-size-100">
                <div class="avatar">
                  <img
                    :src="img"
                    alt="Rounded Image"
                    class="rounded"
                  />
                </div>
                <div class="md-layout-item text-center">
                    <md-button href="#/crop" class="md-simple md-success md-lg">
                    고구마
                    </md-button>
                </div>
            </div>
            <div class="md-layout-item md-size-25 md-xsmall-size-100 ml-auto">
                <div class="avatar">
                  <img
                    :src="img"
                    alt="Rounded Image"
                    class="rounded"
                  />
                </div>
                <div class="md-layout-item text-center">
                    <md-button href="#/crop" class="md-simple md-success md-lg">
                    고구마
                    </md-button>
                </div>
            </div>
            <div class="md-layout-item md-size-25 md-xsmall-size-100 ml-auto">
                <div class="avatar">
                  <img
                    :src="img"
                    alt="Rounded Image"
                    class="rounded"
                  />
                </div>
                <div class="md-layout-item text-center">
                    <md-button href="#/crop" class="md-simple md-success md-lg">
                    고구마
                    </md-button>
                </div>
            </div>
          </div>
          <div class="md-layout">
            <div class="md-layout-item md-size-25 md-xsmall-size-100">
                <div class="avatar">
                  <img
                    :src="img"
                    alt="Rounded Image"
                    class="rounded"
                  />
                </div>
                <div class="md-layout-item text-center">
                    <md-button href="#/crop" class="md-simple md-success md-lg">
                    고구마
                    </md-button>
                </div>
            </div>
            <div class="md-layout-item md-size-25 md-xsmall-size-100 ml-auto">
                <div class="avatar">
                  <img
                    :src="img"
                    alt="Rounded Image"
                    class="rounded"
                  />
                </div>
                <div class="md-layout-item text-center">
                    <md-button href="#/crop" class="md-simple md-success md-lg">
                    고구마
                    </md-button>
                </div>
            </div>
            <div class="md-layout-item md-size-25 md-xsmall-size-100 ml-auto">
                <div class="avatar">
                  <img
                    :src="img"
                    alt="Rounded Image"
                    class="rounded"
                  />
                </div>
                <div class="md-layout-item text-center">
                    <md-button href="#/crop" class="md-simple md-success md-lg">
                    고구마
                    </md-button>
                </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

import { Tabs } from "@/components";
export default {
  components: {
  },
  bodyClass: "profile-page",
  data() {
    return {
      cropslist:[],
      place: ["베란다", "옥상정원", "주말농장"]
    };
  },
  methods: {
    getCropsList(place) {
      axios({
        method: "get",
        url: `${SERVER_URL}/guide/${place}/`
      })
        .then(res => {
          this.cropslist = res.data;
          console.log(this.croplist);
        })
        .catch(error => {
          console.log(error);
        });

    },
  },
  props: {
    header: {
      type: String,
      default: require("@/assets/img/city-profile.jpg")
    },
    img: {
      type: String,
      default: require("@/assets/img/faces/christian.jpg")
    }
  },
  computed: {
    headerStyle() {
      return {
        backgroundImage: `url(${this.header})`
      };
    }
  }
};
</script>

<style lang="scss" scoped>
.section {
  padding: 0;
}
</style>

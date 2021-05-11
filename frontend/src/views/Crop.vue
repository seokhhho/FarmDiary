<template>
  <div class="wrapper">
    <parallax
      class="section page-header header-filter"
      :style="headerStyle"
    ></parallax>
    <div class="main main-raised">
      <h2 class="text-center">
        고구마
      </h2>
      <div class="md-layout">
      <div class="md-layout-item">
        <div class="tim-typo">
          <h3 class="title">
            재배 적응 환경
          </h3>
          <p class="text-muted">
            발아 적온 : 25~30℃<br>
            생육 적온 : 17℃(밤)~27℃(낮)<br>
            생육 장애온도 : 10℃이하, 30℃이상<br>
            토양 : 배수가 양호하고 비옥한 토지가 좋고 가지과 작물을 재배한 적이 없는 곳이 좋다.<br>
            토양산도 : 6.0~6.4정도의 약산성이 좋음.<br>
            광 적응성 : 광포화점은 7만lux로 높으며 빛이 적으면 꽃가루의 기능이 약화 되어 낙과비대부진 등의 현상이 일어남.
          </p>
        </div>
        <div class="tim-typo">
          <h3 class="title">
            모종 아주심기
          </h3>
          <p class="text-muted">
            땅 온도가 17℃이상 되어야 활착이 잘 된다.<br>
            햇볕이 좋고 기온이 높은 날을 택해 심는다.<br>
            모종심고 임시 대나무 등으로 지주를 세워주면 뿌리가 빨리 내린다.<br>
            좋은묘 : 묘의 전체 모습이 장방형, 충실한 쌍떡잎이 맨 아래 붙어 있음, 하엽이 누렇게 변하지 않음, 병해나 충해를 입지 않음, 잎이 두껍고 흐늘거리지 않음, 제 1화방에 충실한 꽃과 꽃봉오리가 여러개 있음
          </p>
        </div>
      </div>
      </div>

    </div>
  </div>
</template>

<script>
import { Tabs } from "@/components";
export default {
  components: {
  },
  bodyClass: "profile-page",
  data() {
    return {
      
    };
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

    package com.jinouk.lostark.simulator.dto;
    
    import lombok.Getter;
    import lombok.Setter;
    import lombok.ToString;
    import java.util.List;
    
    @Getter
    @Setter
    @ToString
    public class skillsDto {
        private String characterName;
        private String characterClass;
        private List<SkillDto> Skills;
        private IdentityDto identity;
    
        // --- 내부 클래스들 ---
    
        @Getter @Setter @ToString
        public static class SkillDto {
            private String name;
            private Integer level;
            private List<String> tripods;
        }
    
        @Getter @Setter @ToString
        public static class IdentityDto {
            private String name;
            private String z;
            private String x;
        }
    }
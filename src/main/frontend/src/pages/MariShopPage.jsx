import React, { useState, useEffect } from 'react';
import SsalsoongiLogo from '../assets/쌀숭이.png';
import {
    Search, X, ExternalLink, MousePointer2,
    Sun, Moon, LayoutDashboard, ShoppingBag, Trophy, Library,
    Shield, Swords, Star, Zap, BarChart3, Box
} from 'lucide-react';

// --- 임시 데이터 ---
const mockCharacterData = {
    name: "치킨버거사주세요",
    server: "카마인",
    job: "슬레이어",
    itemLevel: "1642.50",
    expLevel: "70",
    guild: "치킨은못참지",
    title: "운명의 부름",
    stats: [
        { label: "치명", value: "654" },
        { label: "특화", value: "1842" },
        { label: "신속", value: "52" }
    ],
    engravings: ["처단자 Lv.3", "원한 Lv.3", "예리한 둔기 Lv.3", "돌격대장 Lv.3", "아드레날린 Lv.3"]
};

export default function MidnightModeLayout() {
    const [isDark, setIsDark] = useState(true);
    const [searchQuery, setSearchQuery] = useState('');
    const [showResult, setShowResult] = useState(false);
    const [showBottomAd, setShowBottomAd] = useState(true);

    useEffect(() => {
        document.body.style.backgroundColor = isDark ? '#0a0a0c' : '#f8f9fa';
    }, [isDark]);

    const handleSearch = () => {
        if (searchQuery === "치킨버거사주세요") {
            setShowResult(true);
        } else {
            alert("'치킨버거사주세요'를 입력하면 결과가 나타납니다!");
            setShowResult(false);
        }
    };

    const handleKeyDown = (e) => {
        if (e.key === 'Enter') handleSearch();
    };

    return (
        <div className={`min-h-screen transition-colors duration-500 font-sans selection:bg-[#4c1d95]/30 overflow-x-hidden
            ${isDark ? 'bg-[#0a0a0c] text-[#ececec]' : 'bg-[#f8f9fa] text-[#1e1b4b]'}`}>

            {/* --- Header 영역 --- */}
            <header className={`fixed top-0 w-full z-[100] px-10 h-32 flex justify-between items-center backdrop-blur-3xl border-b transition-all duration-500
                ${isDark ? 'bg-[#0d0d10]/95 border-[#2e1065]/40 shadow-2xl' : 'bg-white/90 border-[#2e1065]/10 shadow-lg'}`}>

                {/* 리듬감 있는 RIO 로고 */}
                <div onClick={() => setShowResult(false)} className="flex items-center gap-8 cursor-pointer group px-4 py-2 rounded-[30px] transition-all hover:bg-[#6d28d9]/5">
                    <div className="relative">
                        <div className={`absolute -inset-4 blur-3xl rounded-full opacity-20 group-hover:opacity-60 transition-all duration-700 ${isDark ? 'bg-[#6d28d9]' : 'bg-[#2e1065]'}`} />
                        <div className={`absolute inset-0 rounded-full border-2 border-dashed scale-125 opacity-0 group-hover:opacity-20 group-hover:rotate-180 transition-all duration-1000 ${isDark ? 'border-white' : 'border-[#2e1065]'}`} />
                        <img src={SsalsoongiLogo} alt="Logo" className="relative w-28 h-28 object-contain transition-all duration-700 group-hover:scale-110 group-hover:-rotate-6" />
                    </div>
                    <div className="flex flex-col -space-y-1">
                        <div className="flex items-baseline">
                            <span className="text-[64px] font-[1000] tracking-[-0.08em] leading-none" style={{ fontVariationSettings: '"wght" 950' }}>
                                <span className="text-[#6d28d9]">R</span>IO
                            </span>
                            <span className="w-3 h-3 rounded-full bg-[#6d28d9] ml-1 shadow-[0_0_10px_#6d28d9] animate-bounce" />
                        </div>
                        <div className="flex items-center gap-3 ml-1">
                            <div className={`h-[1px] w-6 transition-all group-hover:w-12 ${isDark ? 'bg-white/20' : 'bg-[#2e1065]/20'}`} />
                            <span className="text-[13px] font-bold tracking-[0.4em] uppercase opacity-40">Archive</span>
                        </div>
                    </div>
                </div>

                {/* 네비게이션 */}
                <nav className="flex items-center gap-12">
                    {[
                        { name: 'SIMULATOR', icon: <LayoutDashboard size={24} /> },
                        { name: 'MARKET', icon: <ShoppingBag size={24} /> },
                        { name: 'RANKING', icon: <Trophy size={24} /> },
                        { name: 'ARCHIVE', icon: <Library size={24} /> }
                    ].map((item) => (
                        <a key={item.name} href="#" className={`relative flex flex-col items-center gap-2 text-[14px] font-black group ${isDark ? 'text-white/40 hover:text-white' : 'text-[#94a3b8] hover:text-[#2e1065]'}`}>
                            <span className="group-hover:-translate-y-1.5 transition-transform duration-300 group-hover:text-[#6d28d9]">{item.icon}</span>
                            <span className="text-[10px] opacity-80">{item.name}</span>
                            <span className="absolute -bottom-4 left-0 w-0 h-[3px] bg-[#6d28d9] rounded-full transition-all group-hover:w-full" />
                        </a>
                    ))}
                </nav>

                {/* 우측 액션 */}
                <div className="flex items-center gap-8">
                    <button onClick={() => setIsDark(!isDark)} className={`p-4 rounded-2xl border-2 transition-all shadow-lg ${isDark ? 'border-white/10 text-amber-400 hover:bg-white/5' : 'border-[#2e1065]/10 text-[#2e1065] hover:bg-[#2e1065]/5'}`}>
                        {isDark ? <Sun size={26} fill="currentColor" /> : <Moon size={26} fill="currentColor" />}
                    </button>
                    <button className={`px-10 py-4 rounded-[22px] border-2 text-[13px] font-black tracking-[0.2em] transition-all shadow-xl active:scale-95 ${isDark ? 'border-[#6d28d9]/50 text-white bg-[#6d28d9]/10 hover:bg-[#6d28d9]' : 'border-[#2e1065] text-white bg-[#2e1065] hover:brightness-125'}`}>
                        Sign In
                    </button>
                </div>
            </header>

            {/* --- 사이드 광고 (다크모드 대응) --- */}
            <AdPanel side="left" isDark={isDark} />
            <AdPanel side="right" isDark={isDark} />

            {/* --- 메인 컨텐츠 --- */}
            <main className={`relative pt-60 pb-48 px-8 mx-auto z-10 transition-all duration-700 ${showResult ? 'max-w-[1100px]' : 'max-w-[800px]'}`}>

                {/* 검색창 섹션 */}
                <section className={`w-full transition-all duration-700 ${showResult ? 'mb-12 scale-90' : 'mb-20'}`}>
                    <div className="relative group">
                        <div className={`absolute -inset-1 rounded-[24px] blur-2xl opacity-50 group-focus-within:opacity-100 transition-opacity ${isDark ? 'bg-[#2e1065]/30' : 'bg-[#2e1065]/10'}`} />
                        <div className={`relative flex items-center border-2 rounded-[24px] p-2 transition-all ${isDark ? 'bg-[#121216] border-white/[0.08] focus-within:border-[#6d28d9]/50' : 'bg-white border-[#e2e8f0] focus-within:border-[#2e1065]/40'}`}>
                            <div className="flex items-center flex-grow pl-7">
                                <Search className={isDark ? 'text-white/20' : 'text-[#cbd5e1]'} size={24} />
                                <input
                                    type="text" value={searchQuery} onChange={(e) => setSearchQuery(e.target.value)} onKeyDown={handleKeyDown}
                                    placeholder="분석할 모험가의 닉네임을 입력하세요"
                                    className={`w-full bg-transparent border-none text-xl px-5 py-5 focus:ring-0 font-semibold ${isDark ? 'text-white' : 'text-[#1e1b4b]'}`}
                                />
                            </div>
                            <button onClick={handleSearch} className="h-16 px-12 rounded-[18px] bg-[#2e1065] text-white font-black text-xs tracking-[0.2em] hover:brightness-125 transition-all flex items-center gap-3 shadow-lg">
                                SEARCH <MousePointer2 size={16} />
                            </button>
                        </div>
                    </div>
                </section>

                {/* 조건부 렌더링: 결과창 vs 기본 화면 */}
                {showResult ? (
                    <CharacterResultContent data={mockCharacterData} isDark={isDark} />
                ) : (
                    <div className={`w-full space-y-6 opacity-20 animate-pulse ${isDark ? 'mix-blend-lighten' : 'mix-blend-multiply'}`}>
                        <div className="w-full h-14 rounded-xl border bg-current" />
                        <div className="w-full h-72 rounded-3xl border bg-current" />
                    </div>
                )}
            </main>

            {/* 하단 배너 광고 */}
            {showBottomAd && <BottomBanner isDark={isDark} onClose={() => setShowBottomAd(false)} />}
        </div>
    );
}

// --- 캐릭터 결과 컴포넌트 ---
function CharacterResultContent({ data, isDark }) {
    return (
        <div className="w-full space-y-8 animate-in fade-in slide-in-from-bottom-10 duration-1000">
            {/* 프로필 카드 */}
            <section className={`relative overflow-hidden rounded-[40px] p-10 border transition-all ${isDark ? 'bg-[#121216] border-white/5 shadow-2xl' : 'bg-white border-[#2e1065]/10 shadow-xl'}`}>
                <div className="absolute top-0 right-0 w-[400px] h-[400px] bg-[#6d28d9]/10 blur-[100px] -z-10 rounded-full" />
                <div className="flex flex-col md:flex-row gap-10 items-center">
                    <div className="relative group">
                        <div className="absolute -inset-2 bg-gradient-to-br from-[#6d28d9] to-[#4c1d95] rounded-full blur-lg opacity-40 group-hover:opacity-100 transition duration-500" />
                        <div className={`relative w-44 h-44 rounded-full overflow-hidden border-4 ${isDark ? 'border-[#1a1a1b]' : 'border-white'} shadow-2xl bg-black/20`}>
                            <div className="w-full h-full flex items-center justify-center text-white/20 italic">No Image</div>
                        </div>
                        <div className="absolute -bottom-2 left-1/2 -translate-x-1/2 bg-[#6d28d9] text-white px-4 py-1 rounded-full text-[12px] font-black shadow-lg">Lv.{data.expLevel}</div>
                    </div>
                    <div className="flex-grow space-y-4 text-center md:text-left">
                        <div className="flex items-center justify-center md:justify-start gap-3">
                            <span className={`px-3 py-1 rounded-lg text-[10px] font-black tracking-widest ${isDark ? 'bg-white/5 text-[#a78bfa]' : 'bg-[#6d28d9]/10 text-[#2e1065]'}`}>@{data.server}</span>
                            <span className="text-[#6d28d9] font-bold text-[14px]">{data.title}</span>
                        </div>
                        <h2 className={`text-[42px] font-[1000] tracking-tight leading-none ${isDark ? 'text-white' : 'text-[#1e1b4b]'}`}>{data.name}</h2>
                        <p className="text-[#6d28d9] font-bold text-[18px] opacity-80">{data.job}</p>
                        <div className="flex items-center justify-center md:justify-start gap-6 pt-2">
                            <div className="flex flex-col"><span className="text-[11px] font-bold opacity-40 uppercase">Item Level</span><span className="text-[24px] font-[900] text-[#6d28d9]">{data.itemLevel}</span></div>
                            <div className="w-[1px] h-10 bg-current opacity-10" />
                            <div className="flex flex-col"><span className="text-[11px] font-bold opacity-40 uppercase">Guild</span><span className={`text-[18px] font-black ${isDark ? 'text-white/80' : 'text-[#1e1b4b]/80'}`}>{data.guild}</span></div>
                        </div>
                    </div>
                </div>
            </section>

            {/* 상세 스탯 그리드 */}
            <div className="grid grid-cols-1 lg:grid-cols-2 gap-8">
                <div className={`p-8 rounded-[35px] border ${isDark ? 'bg-[#121216] border-white/5' : 'bg-white border-[#2e1065]/10 shadow-lg'}`}>
                    <h3 className="flex items-center gap-3 text-[18px] font-black mb-6 uppercase tracking-widest"><Zap size={20} className="text-[#6d28d9]" /> 전투 특성</h3>
                    <div className="space-y-4">
                        {data.stats.map(stat => (
                            <div key={stat.label} className="flex items-center justify-between group">
                                <span className="font-bold opacity-50">{stat.label}</span>
                                <div className="flex items-center gap-4 flex-grow px-8">
                                    <div className={`h-1.5 flex-grow rounded-full ${isDark ? 'bg-white/5' : 'bg-[#f1f5f9]'}`}>
                                        <div className="h-full bg-[#6d28d9] rounded-full shadow-[0_0_10px_#6d28d9]" style={{ width: `${(parseInt(stat.value)/2000)*100}%` }} />
                                    </div>
                                </div>
                                <span className={`font-black text-[16px] ${isDark ? 'text-white' : 'text-[#1e1b4b]'}`}>{stat.value}</span>
                            </div>
                        ))}
                    </div>
                </div>
                <div className={`p-8 rounded-[35px] border ${isDark ? 'bg-[#121216] border-white/5' : 'bg-white border-[#2e1065]/10 shadow-lg'}`}>
                    <h3 className="flex items-center gap-3 text-[18px] font-black mb-6 uppercase tracking-widest"><Shield size={20} className="text-[#6d28d9]" /> 장착 각인</h3>
                    <div className="flex flex-wrap gap-3">
                        {data.engravings.map(en => (
                            <div key={en} className={`px-4 py-2 rounded-xl text-[12px] font-bold border ${isDark ? 'bg-white/5 border-white/10 text-white/80' : 'bg-[#6d28d9]/5 border-[#6d28d9]/10 text-[#2e1065]'}`}>{en}</div>
                        ))}
                    </div>
                </div>
            </div>
        </div>
    );
}

// --- 기타 UI 컴포넌트 ---
function AdPanel({ side, isDark }) {
    const sideClass = side === 'left' ? 'left-6' : 'right-6';
    return (
        <aside className={`fixed ${sideClass} top-40 hidden xl:block w-[180px] h-[calc(100vh-180px)] z-40`}>
            <div className={`w-full h-full border rounded-2xl overflow-hidden flex flex-col shadow-2xl transition-all duration-500 ${isDark ? 'bg-[#121216] border-white/[0.05]' : 'bg-white border-[#2e1065]/10'}`}>
                <div className={`px-4 py-3 border-b ${isDark ? 'bg-white/5 border-white/5' : 'bg-[#f8f9fa] border-[#2e1065]/5'}`}>
                    <span className={`text-[9px] font-black uppercase tracking-widest ${isDark ? 'text-white/20' : 'text-[#2e1065]/40'}`}>Sponsored</span>
                </div>
                <div className="flex-grow p-5 flex flex-col items-center justify-center text-center gap-4">
                    <div className={`w-full aspect-[3/4] rounded-xl border flex items-center justify-center text-[10px] italic ${isDark ? 'bg-black border-white/5 text-[#2e1065]' : 'bg-[#f1f5f9] border-[#2e1065]/10 text-[#cbd5e1]'}`}>AD AREA</div>
                    <p className={`text-[11px] font-bold leading-relaxed tracking-tighter ${isDark ? 'text-white/30' : 'text-[#2e1065]/60'}`}>아크라시아를 위한 <br/>최적의 파트너십</p>
                </div>
            </div>
        </aside>
    );
}

function BottomBanner({ isDark, onClose }) {
    return (
        <div className="fixed bottom-8 left-1/2 -translate-x-1/2 w-[95%] max-w-[850px] z-[100] animate-in fade-in slide-in-from-bottom-4 duration-500">
            <div className={`relative overflow-hidden rounded-3xl border shadow-2xl flex items-center transition-all ${isDark ? 'bg-[#0d0d10] border-white/10' : 'bg-white border-[#e2e8f0]'}`}>
                <div className={`hidden sm:block w-36 h-28 flex-shrink-0 bg-gradient-to-br ${isDark ? 'from-[#2e1065] to-[#0d0d10]' : 'from-[#2e1065]/20 to-white'}`} />
                <div className="flex flex-grow items-center justify-between px-10 py-6">
                    <div className="flex flex-col gap-1">
                        <span className={`text-[11px] font-black uppercase ${isDark ? 'text-[#6d28d9]' : 'text-[#2e1065]'}`}>Loa-Shop.net</span>
                        <h4 className={`font-bold text-[15px] ${isDark ? 'text-white' : 'text-[#1e1b4b]'}`}>아크라시아 최저가 거래 플랫폼</h4>
                    </div>
                    <div className="flex items-center gap-6">
                        <button className={`px-7 py-3.5 rounded-2xl text-[12px] font-black tracking-widest ${isDark ? 'bg-white text-black hover:bg-[#6d28d9] hover:text-white' : 'bg-[#2e1065] text-white hover:brightness-125'}`}>
                            바로가기 <ExternalLink size={14} />
                        </button>
                        <button onClick={onClose} className="text-[#cbd5e1] hover:text-red-400"><X size={22} /></button>
                    </div>
                </div>
            </div>
        </div>
    );
}
-- 清洗后的植物数据导入
USE chronogarden;

-- 清空表
TRUNCATE TABLE plants;

-- 插入数据
INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '三七',
    'Panax notoginseng',
    '三七 (Panax notoginseng)',
    '三七（Panax notoginseng）是五加科（Araliaceae）人参属（Panax）的一种植物，英文常称为Chinese ginseng或notoginseng。在中文中，它被称为田七、天池人参、三七或三七根，以及山药。三七与人参（Panax ginseng）属于同一科学属。三七自然生长于中国。这种草本植物为多年生，具有深绿色的叶子，从茎部分枝，中央有一簇红色的浆果。',
    '野外灭绝植物',
    '',
    '',
    'https://en.wikipedia.org/wiki/Panax%20notoginseng',
    '2025-03-20 12:14:43',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '乌来杜鹃',
    'Rhododendron kanehirae',
    '乌来杜鹃 (Rhododendron kanehirae)',
    '台北杜鵑又名柳葉杜鵑、金平氏杜鵑，是杜鹃花科杜鹃花属下的一个种，为台湾特有种、唯一一種陽性性杜鵑花。多年生灌木植物，灌叢高1至3公尺，生長於海拔200至800公尺的岩壁。葉片為互生、橢圓披針形，嫩葉覆有剛毛。花小型，色紫紅，單瓣，於莖條的芽冠頂端單生或簇生，花冠直徑約3至4公分，呈闊鐘型，花萼五裂，花期為每年三月下旬至四月上旬；結卵形蒴果。',
    '野外灭绝植物',
    '',
    '',
    'https://zh.wikipedia.org/wiki/%E4%B9%8C%E6%9D%A5%E6%9D%9C%E9%B9%83',
    '2025-03-20 12:14:21',
    'zh',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '也门紫菀',
    'Psiadia schweinfurthii',
    '也门紫菀 (Psiadia schweinfurthii)',
    'Psiadia schweinfurthii 是一种已灭绝的开花植物，属于菊科。它仅在也门的索科特拉岛发现。',
    '近期已灭绝植物',
    '',
    '',
    'https://en.wikipedia.org/wiki/Psiadia%20schweinfurthii',
    '2025-03-20 12:12:57',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '也门败酱',
    'Valerianella affinis',
    '也门败酱 (Valerianella affinis)',
    'Valeriana extincta 是一种已灭绝的开花植物，属于忍冬科。它是一种年生植物，特有于也门西北部的索科特拉岛的马阿利赫山。',
    '近期已灭绝植物',
    '',
    '',
    'https://en.wikipedia.org/wiki/Valerianella%20affinis',
    '2025-03-20 12:12:46',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '也门阔苞菊',
    'Pluchea glutinosa',
    '也门阔苞菊 (Pluchea glutinosa)',
    'Pluchea glutinosa 是一种属于向日葵科的开花植物，特产于印度洋的索科特拉岛，属于也门共和国。自19世纪以来，该植物在野外未被观察到，现被认为已灭绝。',
    '近期已灭绝植物',
    '',
    '',
    'https://en.wikipedia.org/wiki/Pluchea%20glutinosa',
    '2025-03-20 12:12:35',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '云南藏榄',
    'Diploknema yunnanensis',
    '云南藏榄 (Diploknema yunnanensis)',
    '滇藏榄（学名：Diploknema yunnanensis）也作云南藏榄，一种分布于中国云南西南部地区的常绿乔木，隶属于山榄科藏榄属。滇藏榄是一个极小种群野生植物物种，截止2019年野生环境下仅发现11株，被列为国家一级重点保护野生植物和云南省第一批省级重点保护野生植物名录，属于云南I级保护植物。',
    '野外灭绝植物',
    '',
    '',
    'https://zh.wikipedia.org/wiki/%E4%BA%91%E5%8D%97%E8%97%8F%E6%A6%84',
    '2025-03-20 12:14:33',
    'zh',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '伊兹密尔石蒜',
    'Sternbergia schubertii',
    '伊兹密尔石蒜 (Sternbergia schubertii)',
    'Sternbergia schubertii是一种稀有且很可能已经灭绝的开花植物物种，仅有1839年在土耳其伊兹密尔收集的一个标本。',
    '近期已灭绝植物',
    '',
    '',
    'https://en.wikipedia.org/wiki/Sternbergia%20schubertii',
    '2025-03-20 12:13:27',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '伍德苏铁',
    'Encephalartos woodii',
    '伍德苏铁 (Encephalartos woodii)',
    '恩凯法拉托斯·伍迪（Encephalartos woodii），即伍德苏铁，是一种稀有的苏铁，属于恩凯法拉托斯属，特产于南非夸祖鲁-纳塔尔省的翁戈耶森林。它是世界上最稀有的植物之一，已在野外灭绝，现存的所有标本均为其类型的克隆。该植物的学名和俗名均以约翰·梅德利·伍德（John Medley Wood）命名，他是德班植物园的馆长和南非纳塔尔省政府植物标本馆的主任，于1895年发现了这种植物。它呈棕榈树状，最高可达6米（20英尺）。树干直径约为30至50厘米（12至20英寸），底部最粗，顶部有50至150片叶子的冠。',
    '野外灭绝植物',
    '',
    '',
    'https://en.wikipedia.org/wiki/Encephalartos%20woodii',
    '2025-03-20 12:15:34',
    'en',
    '{"waterNeeds": "The annual rainfall at the site ranges between 750–1,000 millimetres (30–39 in)"}',
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '南洋杉型木',
    'Araucarioxylon arizonicum',
    '南洋杉型木 (Araucarioxylon arizonicum)',
    '阿拉乌卡里木化石（Araucarioxylon arizonicum，亦称为阿戈索木化石 Agathoxylon arizonicum）是一种已灭绝的针叶树物种，是亚利桑那州的州化石。该物种以巨大的树干而闻名，这些树干从北亚利桑那州及邻近的新墨西哥州的钦利组（Chinle Formation）风化而出，尤其是在378.51平方公里（93,530英亩）的化石森林国家公园（Petrified Forest National Park）内。在那里，这些树干的数量非常丰富，以至于被用作建筑材料。这种树的化石木材常被称为“彩虹木”，因为一些标本展现出多种颜色。红色和黄色是由大颗粒的氧化铁形成的，其中黄色是褐铁矿，红色是赤铁矿。紫色的色调来自分布在石英基质中的极细小的赤铁矿球体，而不是锰，尽管有时有人提出这种说法。',
    '中生代植物',
    '250 to 200 million years ago',
    '',
    'https://en.wikipedia.org/wiki/Araucarioxylon%20arizonicum',
    '2025-03-20 11:21:10',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '卡纳塔克紫荆木',
    'Madhuca insignis',
    '卡纳塔克紫荆木 (Madhuca insignis)',
    'Madhuca insignis 是一种属于苏木科（Sapotaceae）的植物，特产于印度。由于栖息地丧失，该物种曾被宣布为灭绝。然而，最近在印度卡纳塔克邦达克希纳卡纳达地区的库马拉达拉河岸发现了一个 Madhuca insignis 的种群。',
    '近期已灭绝植物',
    '',
    '',
    'https://en.wikipedia.org/wiki/Madhuca%20insignis',
    '2025-03-20 12:12:14',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '喀拉拉豆树',
    'Cynometra beddomei',
    '喀拉拉豆树 (Cynometra beddomei)',
    'Cynometra beddomei 是豆科（Fabaceae）中的一种树种，最初是根据印度喀拉拉邦西高止山脉的一棵单独树木进行描述的。1998年，该物种被宣布为灭绝，因为自1870年以来再也没有被发现。此后，在喀拉拉邦和南卡纳塔克的多个地方发现了该物种的树木。国际自然保护联盟（IUCN）的状态在2020年进行了更新，以反映这一情况。该物种面临栖息地丧失的威胁。',
    '近期已灭绝植物',
    '',
    '1998',
    'https://en.wikipedia.org/wiki/Cynometra%20beddomei',
    '2025-03-20 11:29:42',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '喀麦隆茜草',
    'Pausinystalia brachythyrsum',
    '喀麦隆茜草 (Pausinystalia brachythyrsum)',
    'Corynanthe brachythyrsus，别名Pausinystalia brachythyrsum，是一种属于茜草科的植物。它是喀麦隆的特有种。',
    '近期已灭绝植物',
    '',
    '',
    'https://en.wikipedia.org/wiki/Pausinystalia%20brachythyrsum',
    '2025-03-20 11:26:59',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '圣赫勒拿天芥菜',
    'Heliotropium pannifolium',
    '圣赫勒拿天芥菜 (Heliotropium pannifolium)',
    '圣赫勒拿向日葵（Heliotropium pannifolium）现已灭绝，但曾是一种毛叶小灌木，属于紫草科（Boraginaceae）。其高度可达1米。该植物仅在1808年左右由探险家W. Burchell在圣赫勒拿的Broad Gut地区观察到过一次，此后再未被发现。人类对圣赫勒拿岛的影响十分严重，圣赫勒拿向日葵是该岛上几种灭绝植物之一。',
    '近期已灭绝植物',
    '',
    '',
    'https://en.wikipedia.org/wiki/Heliotropium%20pannifolium',
    '2025-03-20 11:24:36',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '圣赫勒拿橄榄',
    'Nesiota elliptica',
    '圣赫勒拿橄榄 (Nesiota elliptica)',
    '圣赫勒拿橄榄（Nesiota elliptica）是一种已灭绝的开花植物。它是属Nesiota的唯一成员。该植物是圣赫勒拿岛特有的，位于南大西洋。尽管其名称中含有“橄榄”，但它与真正的橄榄（Olea europaea）无关，而是属于鼠李科（Rhamnaceae），该科包括刺果和枣。最后一棵野生树木于1994年死亡，最后一棵栽培个体于2003年12月去世，尽管进行了保护努力。因此，它是近期植物灭绝的一个典型例子。圣赫勒拿橄榄属于Phyliceae族，该族大多是南非特有的。圣赫勒拿橄榄原产于岛上750米以上的云雾森林，许多历史记录集中在戴安娜峰（岛上最高点）附近。它生长为一棵小型、低矮的扩展树，具有丰富的分枝。树皮呈深棕色至黑色。叶子呈长椭圆形，深绿色，叶尖向下弯曲。叶子的背面呈浅色，表面有平躺的毛。花期推测为6月至10月，树木开出紧密排列的粉红色花朵，生长在分枝的花序上。这些花朵推测是由当地特有的悬蝇种类Sphaerophoria beattiei授粉的。果实成熟需要一年，呈坚硬的木质荚果，内含光亮的三角形黑色种子。',
    '近期已灭绝植物',
    '',
    '2003',
    'https://en.wikipedia.org/wiki/Nesiota%20elliptica',
    '2025-03-20 11:23:51',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '圣赫勒拿蓝花参',
    'Wahlenbergia roxburghii',
    '圣赫勒拿蓝花参 (Wahlenbergia roxburghii)',
    'Wahlenbergia roxburghii，罗克斯堡铃花或矮卷心菜树，是一种已灭绝的植物，曾是圣赫勒拿岛上四种Wahlenbergia物种中的一员，位于南大西洋。它最后一次被自然主义者约翰·查尔斯·梅利斯于1872年观察到。威廉·罗克斯堡在戴安娜峰的南坡厚密森林中记录了它。德·康多尔在戴安娜峰和哈雷山周围的密林中提到过它。伯切尔在“泰勒附近的沙滩岭”上提到过它。开花期：可能为八月至三月。在梅利斯的时代，它极为稀有，梅利斯的书中没有记录，因为他没有找到它。可能是由于在该岭上种植Phormium tenax的增加，导致Wahlenbergia roxburghii最终灭绝。这是圣赫勒拿植物因人类活动而早期灭绝的一个例子，其历史与绳木（Acalypha rubrinervis）相似。',
    '近期已灭绝植物',
    '',
    '1872',
    'https://en.wikipedia.org/wiki/Wahlenbergia%20roxburghii',
    '2025-03-20 11:24:16',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '坦桑尼亚番荔枝',
    'Anonidium usambarense',
    '坦桑尼亚番荔枝 (Anonidium usambarense)',
    'Anonidium usambarense 是一种高大的树木，属于番荔枝科，曾经是坦桑尼亚的特有种。1910年，在乌桑巴拉山的阿马尼地区以900米的海拔收集到一份标本。尽管在该地区进行了针对该物种的密集实地考察，但未发现其他样本，并于1998年被宣布灭绝。其消失的原因是木材工业和扩展农业用地的需求。',
    '近期已灭绝植物',
    '',
    '1998',
    'https://en.wikipedia.org/wiki/Anonidium%20usambarense',
    '2025-03-20 11:25:08',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '夏威夷牛藤',
    'Achyranthes atollensis',
    '夏威夷牛藤 (Achyranthes atollensis)',
    'Achyranthes atollensis（也称为环礁牛膝草或夏威夷稻草花）是一种属于苋科的植物。它是夏威夷西北群岛的特有种，分布于库雷岛、中途岛、莱桑岛以及珍珠和赫尔墨斯环礁。它的自然栖息地为沙质海岸。',
    '近期已灭绝植物',
    '',
    '1964',
    'https://en.wikipedia.org/wiki/Achyranthes%20atollensis',
    '2025-03-20 12:13:52',
    'en',
    '{"soilType": "calcareous sand"}',
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '封印木属',
    'Sigillaria',
    '封印木属 (Sigillaria)',
    'Sigillaria是一个已灭绝的、具有孢子产生能力的树状蕨类植物属，主要出现在石炭纪和二叠纪。它与更著名的鳞木属（Lepidodendron）有亲缘关系，并与现代的羽毛藓类植物有较远的联系。该属的化石记录可以追溯到中泥盆纪或晚石炭纪，但在早二叠纪时逐渐灭绝（年龄范围：距今约3.837亿至2.54亿年）。化石分布于英国、美国、加拿大、中国、韩国、坦桑尼亚和津巴布韦。',
    '古生代植物',
    'Middle Devonian or the Late Carboniferous period',
    'Early Permian period',
    'https://en.wikipedia.org/wiki/Sigillaria',
    '2025-03-20 11:18:43',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '尖叶娑罗双',
    'Shorea cuspidata',
    '尖叶娑罗双 (Shorea cuspidata)',
    'Richetia cuspidata是龙脑香科的一种植物。它是婆罗洲的特有树种。它原产于沙捞越和西加里曼丹，生长在海拔 600 米以下的低地混合龙脑香科森林中。它被列入IUCN红色名录的易危物种名单，已知种群分布在巴哥山和兰卑尔山。',
    '近期已灭绝植物',
    '',
    '',
    'https://en.wikipedia.org/wiki/Shorea%20cuspidata',
    '2025-03-20 12:13:08',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '尼尔吉里冬青',
    'Ilex gardneriana',
    '尼尔吉里冬青 (Ilex gardneriana)',
    'Ilex gardneriana 是一种极度濒危的植物，属于冬青科（Aquifoliaceae）。它是印度尼尔吉里山的特有种。',
    '近期已灭绝植物',
    '',
    '',
    'https://en.wikipedia.org/wiki/Ilex%20gardneriana',
    '2025-03-20 12:12:02',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '开通目',
    'Caytoniales',
    '开通目 (Caytoniales)',
    '凯顿目（Caytoniales）是一类已灭绝的种子植物，化石分布于中生代（约2.52亿至6600万年前）。它们被视为种子蕨，因为它们是具有蕨类植物特征的种子植物，叶片类似蕨类。尽管曾因其果实状的杯状结构而被认为是被子植物，但这一假说后来被推翻。然而，一些学者认为它们可能是被子植物的祖先或近亲。被子植物的起源仍不清楚，且无法与任何已知的种子植物群体确切关联。该目中最早的化石是在约克郡凯顿湾的克劳顿组中发现的中侏罗世格里斯索普层，凯顿湾的名称也因此命名了这一类群。此后，它们在全球的中生代岩石中被发现。凯顿目植物可能在湿地地区繁盛，因为它们常与其他喜湿植物如马尾草一起出现在水淹的古土壤中。最早的凯顿目化石以压缩形式保存在页岩中，切膜的保存状态极佳，使得细胞组织学的研究成为可能。',
    '中生代植物',
    '252 million years ago',
    '66 million years ago',
    'https://en.wikipedia.org/wiki/Caytoniales',
    '2025-03-20 11:23:14',
    'en',
    '{"waterNeeds": "wetland areas", "soilType": "waterlogged paleosols"}',
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '意大利扁萼苔',
    'Radula visianica',
    '意大利扁萼苔 (Radula visiniaca)',
    'Radula visianica 是一种属于 Radulaceae 科的肝苔类植物。它是欧洲阿尔卑斯山的特有种。自1938年以来被认为已经灭绝，但在2014年在奥地利重新被发现。Radula visianica 由意大利植物学家卡罗·马萨隆戈于1904年首次描述，基于他在1878年2月收集的标本。该物种名称以19世纪植物学家罗伯托·德·维西安尼命名，他在意大利东北部的尤加尼山靠近原始采集地点拥有一座别墅。该物种属于 Radulaceae 科的 Radula 属，位于肝苔类植物（Marchantiophyta）的 Porellales 目。',
    '近期已灭绝植物',
    '',
    '1938',
    'https://en.wikipedia.org/wiki/Radula%20visianica',
    '2025-03-20 11:27:23',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '拟查米亚属',
    'Zamites',
    '拟查米亚属 (Zamites)',
    'Zamites是一个已灭绝的植物属，属于威廉逊科（Williamsoniaceae），生存于三叠纪至始新世。该植物在中生代的北美洲、南美洲、欧洲、亚洲、非洲和南极洲都有发现，而在新生代仅在北美洲出现。叶片呈 lanceolate（披针形）至 linear-lanceolate（线状披针形），其尺寸在50至60厘米之间。小羽片在基部对称聚集，并通过基部斜向连接到叶轴的上表面。小羽片的顶端为钝头（尖锐）。叶脉从聚集部分发出，相互之间呈发散状。它们可分叉一次或多次，并切割小羽片的边缘。主脉可以延伸至小羽片的末端。该植物与种子球果威廉逊（Williamsonia）和雄球果韦尔特里希（Weltrichia）相关联。',
    '中生代植物',
    '三叠纪',
    '始新世',
    'https://en.wikipedia.org/wiki/Zamites',
    '2025-03-20 11:21:29',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '斯里兰卡豆树',
    'Crudia zeylanica',
    '斯里兰卡豆树 (Crudia zeylanica)',
    '克鲁迪亚·锡兰尼卡（Crudia zeylanica），有时被称为斯里兰卡豆，是豆科（Fabaceae）的一种植物，特产于斯里兰卡。曾一度被认为已经灭绝，该植物于2019年重新被发现。位于甘帕哈的达拉卢瓦地区的克鲁迪亚·锡兰尼卡标本，于2023年7月11日星期二被砍伐，这一标本曾被描述为世界上已知的唯一野生豆科植物标本，砍伐是为了进行四车道高速公路的持续建设。',
    '近期已灭绝植物',
    '',
    '',
    'https://en.wikipedia.org/wiki/Crudia%20zeylanica',
    '2025-03-20 11:29:27',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '日月潭羊耳蒜',
    'Liparis hensoensis',
    '日月潭羊耳蒜 (Liparis hensoensis)',
    '日月潭羊耳蒜（學名：Liparis hensoaensis），為台灣特有種蘭花，已滅絕。原本分布於南投縣日月潭地區的拉魯島，海拔約750m左右。假球莖卵形。葉為線形或線狀披針形，長16-30公分，僅1-1.5公分寬。總狀花序頂生。上萼片及花瓣線形，長約九公厘，唇瓣卵狀橢圓形。在明潭水庫建設後其棲地遭受嚴重破壞。目前已超過70年未有後續發現紀錄，可能已完全絕滅。在演替後期常可見浮島，最初發現的地點此生育環境中的草叢中，如今環境的變遷，已完全消失，並無再發現其蹤跡。',
    '近期已灭绝植物',
    '',
    '',
    'https://zh.wikipedia.org/wiki/%E6%97%A5%E6%9C%88%E6%BD%AD%E7%BE%8A%E8%80%B3%E8%92%9C',
    '2025-03-20 11:28:11',
    'zh',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '星肯坡垒',
    'Hopea shingkeng',
    '星肯坡垒 (Hopea shingkeng)',
    'Hopea shingkeng 是双翅木科的一种植物，特产于印度东喜马拉雅地区。《中国植物志》记录了该物种在东南部西藏的分布。然而，所报告的海拔范围（300–600米）使得这一记录值得怀疑。',
    '近期已灭绝植物',
    '',
    '',
    'https://en.wikipedia.org/wiki/Hopea%20shingkeng',
    '2025-03-20 12:11:53',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '智利檀香',
    'Chamaesyce celastroides var. celastroides',
    '智利檀香 (Chamaesyce celastroides var. celastroides)',
    '智利檀香（Santalum fernandezianum）是檀香屬下的一種植物，原產於智利的胡安·費爾南德斯群島。1908年瑞典植物學家卡尔·斯科特博格在野外看到智利檀香之後就再也不見其蹤跡，據信已經因取其芳香木料而遭濫砍濫伐，最終滅絕。',
    '近期已灭绝植物',
    '',
    '',
    'https://zh.wikipedia.org/wiki/%E6%99%BA%E5%88%A9%E6%AA%80%E9%A6%99',
    '2025-03-20 12:14:07',
    'zh',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '杜仲',
    'Eucommia ulmoides',
    '杜仲 (Eucommia ulmoides)',
    '榆树（Eucommia ulmoides）是一种原产于中国的小型树种，属于单型科榆树科（Eucommiaceae）。在野外被认为是易危物种，但在中国广泛栽培，主要用于其树皮，并在传统中医等草药学中备受重视。榆树的高度可达约15米。叶片为落叶，交替排列，呈简单的卵形，顶端渐尖，长8-16厘米，边缘具锯齿。',
    '野外灭绝植物',
    '10- to 35-million-year-old',
    '',
    'https://en.wikipedia.org/wiki/Eucommia%20ulmoides',
    '2025-03-20 12:14:53',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '枝脉蕨属',
    'Cladophlebis',
    '枝脉蕨属 (Cladophlebis)',
    'Cladophlebis是一种已灭绝的蕨类植物属，已在二叠纪至白垩纪末期的地层中被发现，分布于全球各大洲。一些小羽片的边缘光滑，而另一些则呈锯齿状。中脉明显，侧脉为二叉分枝，延伸至末端。这种蕨类植物具有根茎。该属用于指代古生代和中生代的蕨类叶片，其特征为“蕨类叶片上有小羽片附着于主轴，且有一条中脉延伸至小羽片的顶端，侧脉则呈弯曲并分叉”。',
    '中生代植物',
    'Permian',
    'Cretaceous',
    'https://en.wikipedia.org/wiki/Cladophlebis',
    '2025-03-20 11:21:48',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '楔叶属',
    'Sphenophyllum',
    '楔叶属 (Sphenophyllum)',
    '扁叶蕨属（Sphenophyllum）是扁叶蕨目（Sphenophyllales）中的一个属，已被归入扁叶蕨科（Sphenophyllaceae）。',
    '古生代植物',
    '',
    '',
    'https://en.wikipedia.org/wiki/Sphenophyllum',
    '2025-03-20 11:19:49',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '泣堇菜',
    'Viola cryana',
    '泣堇菜 (Viola cryana)',
    'Viola cryana 是由弗朗索瓦-泽维尔·吉约（François-Xavier Gillot）于1878年描述的一个独立物种，最早在1860年首次报告于法国约讷省的一个特定地点。该标本是在托纳尔东南部的克里地区的小型石灰岩露头上采集的，这种形式的样本在栽培中保持了一段时间。现在该物种已不再存在；该地点的种群在1930年前消失。它是一种栖息地限制于富含方解石的岩石区域的物种，分布范围仅限于塞纳河和安德尔河的谷地。',
    '近期已灭绝植物',
    '',
    '1930',
    'https://en.wikipedia.org/wiki/Viola%20cryana',
    '2025-03-20 11:27:43',
    'en',
    '{"soilType": "calcite-rich, rocky areas"}',
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '狭叶水锦树',
    'Wendlandia angustifolia',
    '狭叶水锦树 (Wendlandia angustifolia)',
    'Wendlandia angustifolia 是一种属于茜草科的植物。它是印度泰米尔纳德邦的特有种。该物种曾被认为已经灭绝，直到1998年，在泰米尔纳德邦卡拉卡德·蒙丹塔赖虎保护区进行濒危植物清查时，经过81年的间隔再次被发现，地点接近其之前已知的自然栖息地。',
    '近期已灭绝植物',
    '',
    '',
    'https://en.wikipedia.org/wiki/Wendlandia%20angustifolia',
    '2025-03-20 12:12:24',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '瓜耳木',
    'Otophora unilocularis',
    '瓜耳木 (Otophora unilocularis)',
    '单室蕊果（Lepisanthes unilocularis）是无患子科（Sapindaceae）的一种植物。它是中国特有种。该物种曾被认为已经灭绝，直到2018年被重新发现。',
    '近期已灭绝植物',
    '',
    '',
    'https://en.wikipedia.org/wiki/Otophora%20unilocularis',
    '2025-03-20 11:28:46',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '短叶杉属',
    'Brachyphyllum',
    '短叶杉属 (Brachyphyllum)',
    '短叶属（Brachyphyllum，意为“短叶”）是一种化石针叶植物叶片的形式属。该属植物被不同地归类于多个不同的针叶植物群，包括南洋杉科（Araucariaceae）和切罗雷皮迪科（Cheirolepidiaceae）。它们的化石分布遍及全球，时间跨度从晚石炭纪到晚白垩纪。模式种B. sattlerae以虚构古植物学家艾莉·萨特勒（Ellie Sattler）命名，后者出自《侏罗纪公园》系列作品。',
    '中生代植物',
    'Late Carboniferous',
    'Late Cretaceous',
    'https://en.wikipedia.org/wiki/Brachyphyllum',
    '2025-03-20 11:22:52',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '短叶柄苏铁',
    'Encephalartos brevifoliolatus',
    '短叶柄苏铁 (Encephalartos brevifoliolatus)',
    '短叶脑叶龙脑树（Encephalartos brevifoliolatus），又称悬崖龙脑树，是非洲属（Encephalartos）中的一种龙脑树。它在野外已经灭绝。悬崖龙脑树生长在南非林波波省北德拉肯斯堡悬崖的开阔普罗提亚草原上的短草原中。这种植物为雌雄异株的小树，具有单一的无分枝茎干，通常在基部产生侧芽，形成最多可达6个茎干的丛生。',
    '野外灭绝植物',
    '',
    '',
    'https://en.wikipedia.org/wiki/Encephalartos%20brevifoliolatus',
    '2025-03-20 12:15:03',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '科特迪瓦刺果藤',
    'Byttneria ivorensis',
    '科特迪瓦刺果藤 (Byttneria ivorensis)',
    'Ayenia ivorensis 是一种属于锦葵科的树木，目前被归类为灭绝物种。它是根据一份在象牙海岸上部几内亚森林中采集的单一标本进行鉴定的。',
    '近期已灭绝植物',
    '',
    '',
    'https://en.wikipedia.org/wiki/Byttneria%20ivorensis',
    '2025-03-20 11:25:24',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '科特迪瓦茜草',
    'Argocoffeopsis lemblinii',
    '科特迪瓦茜草 (Argocoffeopsis lemblinii)',
    'Argocoffeopsis lemblinii 是一种已灭绝的咖啡植物近亲，属于茜草科（Rubiaceae）。它仅通过法国植物学家奥古斯特·让·巴蒂斯特·舍瓦利耶于1907年1月在科特迪瓦阿涅比河谷采集的模式标本而为人所知，之后的调查中未再发现该植物。Argocoffeopsis lemblinii 是一种分枝繁多的灌木，最高可达约50厘米。其花为白色，小果实呈球形。它生长在森林栖息地中。',
    '近期已灭绝植物',
    '',
    '',
    'https://en.wikipedia.org/wiki/Argocoffeopsis%20lemblinii',
    '2025-03-20 11:25:41',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '科达属',
    'Cordaites',
    '科达属 (Cordaites)',
    'Cordaites是一个已灭绝的裸子植物属，与最早的松柏类植物相关或实际上代表了它们。这些树木可生长至100英尺（30米）高，生长在干燥地区以及湿地中。咸水贝类和甲壳类动物常常在这些树的根部之间发现。Cordaites化石最常见于欧洲和美洲的上石炭纪（距今约3.23亿至2.99亿年）的岩石层中。与许多其他植物相比，化石化的Cordaites种子并不稀有，因为它们相对较大（可达10毫米）；这些种子被称为Cordaicarpus。',
    '古生代植物',
    '323 to 299 million years ago',
    '',
    'https://en.wikipedia.org/wiki/Cordaites',
    '2025-03-20 11:20:23',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '类雀麦',
    'Bromus bromoideus',
    '类雀麦 (Bromus bromoideus)',
    '阿登斯的雀麦（Bromus bromoideus）是雀麦属（Bromus）的一种草本植物。基因研究表明，它更应该被视为雀麦（Bromus secalinus）的一个变种。它分布于比利时列日省和卢森堡省的石灰岩草地，特别是在罗什福尔、博朗和孔布兰-奥-庞特等城镇附近，首次发现于1821年。',
    '野外灭绝植物',
    '1821',
    '1930s',
    'https://en.wikipedia.org/wiki/Bromus%20bromoideus',
    '2025-03-20 12:15:44',
    'en',
    '{"soilType": "calcareous meadows"}',
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '粤铁线蕨',
    'Adiantum lianxianense',
    '粤铁线蕨 (Adiantum lianxianense)',
    '连县铁线蕨（Adiantum lianxianense）是一种原产于中国的铁线蕨。尽管国际自然保护联盟（IUCN）红色名录将其列为灭绝物种，因栖息地丧失，但由于常常与该属其他成员混淆，它可能仍然存活。该物种于1980年由郑长青和林有兴首次描述为独立种。类型标本由本杰明·库奇·亨利牧师于1881年在连州（连县）采集，但最初被确定为Adiantum gravesii。郑和林通过其更柔软细腻的生长习性、细长的毛状茎、较小的倒卵形或倒卵形-长方形小羽片（而非宽卵形或倒卵形-三角形）以及宽度为1.5毫米（0.059英寸）的长茎，将连县铁线蕨与该物种区分开来。',
    '近期已灭绝植物',
    '',
    '',
    'https://en.wikipedia.org/wiki/Adiantum%20lianxianense',
    '2025-03-20 11:28:32',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '缘毛红豆',
    'Ormosia howii',
    '缘毛红豆 (Ormosia howii)',
    '海南豆科植物（Ormosia howii）是一种原产于中国南部的开花植物，属于豆科（Fabaceae）。该物种最初于1954年在海南岛的吊罗山被发现，随后在1957年在广东阳春再次被发现，但当时的种群数量极其稀少。目前该物种显然已经灭绝。它是一种小树，高达10米（33英尺），生长在山坡的开阔森林中。',
    '近期已灭绝植物',
    '',
    '',
    'https://en.wikipedia.org/wiki/Ormosia%20howii',
    '2025-03-20 11:29:10',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '肋木属',
    'Pleuromeia',
    '肋木属 (Pleuromeia)',
    'Pleuromeia是一个已灭绝的石松类植物属，与现代的羽毛藻（Isoetes）相关。Pleuromeia在早三叠纪时期主导了整个欧亚大陆及其他地区的植被，这是在二叠纪-三叠纪灭绝事件之后的结果。在这一时期，它常常以单种群落的形式出现。其在未成熟古土壤上的单种群落沉积背景，表明它是一种机会主义先锋植物，能够在竞争较少的矿质土壤上生长。它扩展到具有温室气候条件的高纬度地区。Pleuromeia由一根单一的无分枝茎组成，茎的厚度变化不定，P. sternbergi的最大高度可达2米（6.6英尺），尽管通常较小，而P. jiaochengensis的高度仅约为30厘米（0.98英尺）。茎周围排列着螺旋状的三角形叶片，叶片末端逐渐变尖。这些叶片附着在茎上的菱形叶基上。它具有一个2-4裂的球茎基部，许多附生根系附着于此。Pleuromeia在茎的顶端或某些物种中产生一个单一的异孢大型球果（球果），或多个较小的球果。',
    '中生代植物',
    'Induan',
    'Anisian',
    'https://en.wikipedia.org/wiki/Pleuromeia',
    '2025-03-20 11:22:23',
    'en',
    '{"soilType": "mineral soils"}',
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '舌羊齿属',
    'Glossopteris',
    '舌羊齿属 (Glossopteris)',
    '舌叶木（Glossopteris，词源：来自古希腊语 γλῶσσα (glôssa, "舌头") + πτερίς (pterís, "蕨类植物")）是已灭绝的二叠纪种子植物目——舌叶目（Glossopteridales，亦称为阿尔伯里目、奥托卡里目或网脉蕨目）中最大且最著名的属。舌叶这个名称仅指叶子，属于古植物学中使用的形态属（有关可能的生殖器官，请参见舌叶科 Glossopteridaceae）。舌叶木的物种在二叠纪期间是超大陆冈瓦纳（Gondwana）中中高纬度低地植被的主要树种。舌叶木化石在识别冈瓦纳各个碎片之间的古代联系方面至关重要，这些碎片包括南美洲、非洲、印度、澳大利亚、新西兰和南极洲。舌叶木的叶子以其独特的舌状形状和网状脉络而著称。叶子要么在长茎上间隔较远，要么在短枝上密集螺旋排列。',
    '古生代植物',
    'Cisuralian',
    'Cisuralian',
    'https://en.wikipedia.org/wiki/Glossopteris',
    '2025-03-20 11:20:45',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '芦木属',
    'Calamites',
    '芦木属 (Calamites)',
    'Calamites是一个已灭绝的树状（类似树木）木贼属，与现代木贼（木贼属Equisetum）密切相关。与现代的草本木贼不同，这些植物是中型树木，生长高度可达30至50米（100至160英尺）。它们是石炭纪（约3.6亿至3亿年前）煤沼泽下层植被的组成部分。Calamites的树干具有独特的分段、竹子般的外观和垂直的肋纹。枝条、叶子和球果均以轮生的方式生长。叶子呈针状，每轮可达25片。',
    '古生代植物',
    'around 360 to 300 million years ago',
    '',
    'https://en.wikipedia.org/wiki/Calamites',
    '2025-03-20 11:19:37',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '蓝苏铁',
    'Encephalartos nubimontanus',
    '蓝苏铁 (Encephalartos nubimontanus)',
    '恩氏脑叶龙舌兰（Encephalartos nubimontanus）是一种原产于南非林波波省的苏铁植物。该苏铁具有树状生长模式，直立或倾斜的茎可高达2.5米，直径为35-40厘米。它的基部可能还会生长出额外的茎。叶子呈圆形簇生于茎的顶部，长1-2米，叶柄长23厘米，基部有明显的红色环。',
    '野外灭绝植物',
    '',
    '',
    'https://en.wikipedia.org/wiki/Encephalartos%20nubimontanus',
    '2025-03-20 12:15:14',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '轮叶属',
    'Annularia',
    '轮叶属 (Annularia)',
    '环叶属（Annularia）是一个形式分类群，适用于属于已灭绝的卡拉米特斯属（Calamites）植物的化石叶片，属于马尾植物目（Equisetales）。叶片在每个茎节处形成放射状的叶轮，类似于马尾草（Equisetum）的分枝。叶片以8至13片的轮生方式排列，形状从椭圆形到线形或披针形不等。',
    '古生代植物',
    'Carboniferous',
    'Carboniferous',
    'https://en.wikipedia.org/wiki/Annularia',
    '2025-03-20 11:57:19',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '遗迹苏铁',
    'Encephalartos relictus',
    '遗迹苏铁 (Encephalartos relictus)',
    '恩凯法拉托斯·瑞利克图斯（Encephalartos relictus），也被称为帕尔洛塔苏铁，是一种生长于斯威士兰的苏铁植物。该苏铁在进化上已灭绝，现存的仅为雄性植株，意味着它们无法产生种子。然而，J. J. P. du Preez成功繁殖了一些样本的侧芽。它是一种树状的苏铁，茎高可达2.5米，直径为40–45厘米，次生茎从基部的吸芽处生长。',
    '野外灭绝植物',
    '',
    '',
    'https://en.wikipedia.org/wiki/Encephalartos%20relictus',
    '2025-03-20 12:15:23',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '阿森松茜草',
    'Oldenlandia adscensionis',
    '阿森松茜草 (Oldenlandia adscensionis)',
    '老登兰（Oldenlandia adscensionis）是茜草科（Rubiaceae）的一种植物，特有于阿森松岛（Ascension Island）。由于栖息地丧失，该物种已经灭绝；自1888年以来未再被发现。',
    '近期已灭绝植物',
    '',
    '1888',
    'https://en.wikipedia.org/wiki/Oldenlandia%20adscensionis',
    '2025-03-20 11:26:14',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '阿森松鼠尾栗',
    'Sporobolus durus',
    '阿森松鼠尾栗 (Sporobolus durus)',
    'Sporobolus durus 是一种属于禾本科（Poaceae）的草本植物，仅分布于南大西洋的阿森松岛。由于过度放牧和入侵杂草的取代，它已灭绝。其灭绝的确切时间尚不清楚；最后一次记录是在1886年，但直到1998年才专门进行搜索。',
    '近期已灭绝植物',
    '',
    '1886',
    'https://en.wikipedia.org/wiki/Sporobolus%20durus',
    '2025-03-20 11:26:43',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '马来秋海棠',
    'Begonia eiromischa',
    '马来秋海棠 (Begonia eiromischa)',
    '毛茎秋海棠（Begonia eiromischa）是一种被认为已灭绝的植物，产于马来西亚。它生长在海拔170米的花岗岩岩石上，靠近阔叶树森林。',
    '近期已灭绝植物',
    '1886',
    '2007',
    'https://en.wikipedia.org/wiki/Begonia%20eiromischa',
    '2025-03-20 12:13:18',
    'en',
    NULL,
    NULL
);

INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs, growth_stages)
VALUES (
    '鳞木属',
    'Lepidodendron',
    '鳞木属 (Lepidodendron)',
    '鳞木属（Lepidodendron）是一个已灭绝的原始石松类维管植物属，属于鳞木目（Lepidodendrales）。它在化石记录中保存良好且常见。与其他鳞木目植物一样，鳞木属的物种在湿地煤林环境中生长为大型树状植物。它们有时可达到50米（160英尺）的高度，树干直径常超过1米（3英尺3英寸）。由于其树皮上覆盖着菱形的叶基，早期生长阶段时从中长出叶子，因此它们常被称为“鳞树”。然而，它们的正确分类是树状石松类植物。鳞木属在石炭纪（距今约3.589亿至2.989亿年）期间繁盛，并持续到二叠纪末期，约在2.52亿年前灭绝。',
    '古生代植物',
    '358.9 to 298.9 million years ago',
    '252 million years ago',
    'https://en.wikipedia.org/wiki/Lepidodendron',
    '2025-03-20 11:19:02',
    'en',
    NULL,
    NULL
);


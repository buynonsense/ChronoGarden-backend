import re

def fix_sql_file():
    """修复SQL导入文件中的JSON格式问题"""
    input_file = "sql/import_data.sql"
    output_file = "sql/fixed_import_data.sql"
    
    with open(input_file, 'r', encoding='utf-8') as f:
        lines = f.readlines()
    
    fixed_lines = []
    line_num = 0
    
    for line in lines:
        line_num += 1
        # 替换字符串 'NULL' 为SQL NULL
        if "'NULL'" in line:
            line = line.replace("'NULL'", "NULL")
        
        # 修复JSON格式问题
        if "care_needs" in line or "growth_stages" in line:
            # 如果这行包含JSON对象但格式有问题
            if "{" in line and "}" in line and not line.strip().startswith("--"):
                # 确保JSON字符串格式正确
                pattern = r"'({.*?})'"
                match = re.search(pattern, line)
                if match:
                    json_str = match.group(1)
                    # 修复JSON字符串中的问题
                    if "\\" not in json_str and "\"" not in json_str:
                        # 将单引号转为双引号
                        json_str = json_str.replace("'", "\\'")
                    # 替换回原行
                    line = re.sub(pattern, f"'{json_str}'", line)
        
        fixed_lines.append(line)
    
    # 写入修复后的内容
    with open(output_file, 'w', encoding='utf-8') as f:
        f.writelines(fixed_lines)
    
    print(f"已修复SQL文件并保存到: {output_file}")
    print(f"处理了 {line_num} 行")

if __name__ == "__main__":
    fix_sql_file()
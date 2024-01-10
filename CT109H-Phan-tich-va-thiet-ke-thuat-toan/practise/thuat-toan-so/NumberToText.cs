public string NumberToText(double inputNumber, bool suffix = true)
    {
        string[] array = new string[10] { "khong", "mot", "hai", "ba", "bon", "nam", "sau", "bay", "tam", "chin" };
        string[] array2 = new string[4] { " ", "nghin", "trieu", "ty" };
        string text = inputNumber.ToString("#");
        int num = Convert.ToInt32(text);
        bool flag = false;
        if (num < 0)
        {
            text = (-num).ToString("#");
            flag = true;
        }

        int num2 = text.Length;
        string text2 = " ";
        if (num2 == 0)
        {
            text2 = array[0] + text2;
        }
        else
        {
            int num3 = 0;
            while (num2 > 0)
            {
                int num4;
                int num5 = (num4 = -1);
                int num6 = Convert.ToInt32(text.Substring(num2 - 1, 1));
                num2--;
                if (num2 > 0)
                {
                    num4 = Convert.ToInt32(text.Substring(num2 - 1, 1));
                    num2--;
                    if (num2 > 0)
                    {
                        num5 = Convert.ToInt32(text.Substring(num2 - 1, 1));
                        num2--;
                    }
                }

                if (num6 > 0 || num4 > 0 || num5 > 0 || num3 == 3)
                {
                    text2 = array2[num3] + text2;
                }

                num3++;
                if (num3 > 3)
                {
                    num3 = 1;
                }

                if (num6 == 5 && num4 > 0)
                {
                    text2 = "lam " + text2;
                }
                else if (num6 > 0)
                {
                    text2 = array[num6] + " " + text2;
                }

                if (num4 < 0)
                {
                    break;
                }

                if (num4 == 0 && num6 > 0)
                {
                    text2 = "le " + text2;
                }
                else if (num4 == 1)
                {
                    text2 = "muoi` " + text2;
                }
                else if (num4 > 1)
                {
                    text2 = array[num4] + " muoi " + text2;
                }

                if (num5 < 0)
                {
                    break;
                }

                if (num5 > 0 || num4 > 0 || num6 > 0)
                {
                    text2 = array[num5] + " tram " + text2;
                }

                text2 = " " + text2;
            }
        }

        text2 = text2.Trim();
        if (flag)
        {
            text2 = "Am " + text2;
        }

        return text2 + (suffix ? " dong chan" : "");
    }
}

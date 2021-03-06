﻿USE [豆瓣数据库]
GO
/****** Object:  Table [dbo].[movie]    Script Date: 11/15/2019 09:50:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[movie](
	[movie_id] [int] NOT NULL,
	[name] [char](50) NOT NULL,
	[rate] [float] NOT NULL,
	[imdb_id] [char](10) NOT NULL,
	[alias] [varchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[movie_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[movie] ADD  DEFAULT ('') FOR [name]
GO
ALTER TABLE [dbo].[movie] ADD  DEFAULT ((0.0)) FOR [rate]
GO
ALTER TABLE [dbo].[movie] ADD  DEFAULT ('') FOR [imdb_id]
GO
ALTER TABLE [dbo].[movie] ADD  DEFAULT ('') FOR [alias]
GO
